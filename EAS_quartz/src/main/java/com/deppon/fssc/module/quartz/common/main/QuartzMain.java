package com.deppon.fssc.module.quartz.common.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.common.util.JdbcUtils;
import com.deppon.fssc.module.quartz.server.dao.IQuartzModelDao;

/**
 * 
 *<pre>
 *功能:定时计划任务动态加载的入口
 *作者：谢玉良
 *日期：2013-4-10下午3:26:18
 *</pre>
 */
public class QuartzMain implements BeanFactoryAware {// 实现接口即可对beanfactory进行注入
	/**
	 * 方法引用标识
	 */
	private static int repeatNum = 0;
	/**
	 * 日志实体
	 */
	private Logger log = Logger.getLogger(QuartzMain.class);
	/**
	 * 定时任务池
	 */
	private Scheduler scheduler;
	/**
	 * bean工厂
	 */
	private BeanFactory beanFactory;
	/**
	 * 任务实体操作DAO
	 */
	@Resource
	private IQuartzModelDao quartzModelDao;

	/**
	 *<pre>
	 * 方法体说明：定时计划任务入口方法
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:57:00
	 *</pre>
	 */
	public void startQuartz() {
		if (repeatNum == 0) {// 即程序启动时调用一次，之后则不再调用,采用前台界面的即时更新
			//获取数据库定时任务记录
			List<QuartzModel> qmList = this.getJob();
			if (qmList != null && qmList.size() > 0) {
				for (QuartzModel qm : qmList) {
					//任务初始化
					this.initJob(qm);
				}
			}
			repeatNum++;
		}
	}

	/**
	 *<pre>
	 * 方法体说明：从数据库中加载任务计划bean信息
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:57:09
	 * @return
	 *</pre>
	 */
	private List<QuartzModel> getJob() {
		List<QuartzModel> list = null;
		try {
			//查询参数
			QuartzModel qm=null;
			list = quartzModelDao.queryAll(qm);
			// 校验是否合法
			for (QuartzModel temp : list) {
				//任务名称
				String jobname = temp.getId();
				//时间表达式
				String cronexpression = temp.getCronexpression();
				//是否为bean
				String isbean = temp.getIsbean();
				//任务对象
				String targetobject = temp.getTargetobject();
				//任务方法
				String method = temp.getMethod();
				//是否并发
				String concurrent = temp.getConcurrent();
				//状态
				String state = temp.getState();
				if (StringUtils.isEmpty(jobname)
						|| StringUtils.isEmpty(cronexpression)
						|| StringUtils.isEmpty(isbean)
						|| StringUtils.isEmpty(targetobject)
						|| StringUtils.isEmpty(method)
						|| StringUtils.isEmpty(concurrent)
						|| StringUtils.isEmpty(state)) {
					StringBuffer sb = new StringBuffer();
					//任务名称
					sb.append("jobname:" + jobname + " ");
					//时间表达式
					sb.append("cronexpression:" + cronexpression + " ");
					//是否为bean
					sb.append("isbean:" + isbean + " ");
					//任务对象
					sb.append("targetobject:" + targetobject + " ");
					//任务方法
					sb.append("method:" + method + " ");
					//是否并发
					sb.append("concurrent:" + concurrent + " ");
					//状态
					sb.append("state:" + state);
					//日志记录
					log.error("错误的计划任务信息:" + sb.toString());
					// 移除
					list.remove(temp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("加载定时计划任务出错:" + e);
		}
		return list;
	}

	/**
	 *<pre>
	 * 方法体说明：JDBC模式从数据库中加载任务计划bean信息
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:57:20
	 * @return
	 *</pre>
	 */
	@SuppressWarnings("unused")
	private List<QuartzModel> getJobByJdbc() {
		List<QuartzModel> list = new ArrayList<QuartzModel>();
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getCon();//获取数据库连接
			if (con != null) {
				smt = con.createStatement();
				rs = smt.executeQuery("select * from t_quartz_model");
				while (rs.next()) {// 信息校验与加载
					//获取定时任务计划实体属性值
					//工作名称
					String jobname = rs.getString("jobname");
					//触发器名称
					String triggername = rs.getString("triggername");
					//时间表达式
					String cronexpression = rs.getString("cronexpression");
					//是否为bean
					String isbean = rs.getString("isbean");
					//目标对象
					String targetobject = rs.getString("targetobject");
					//目标对象的方法
					String method = rs.getString("method");
					if (StringUtils.isEmpty(method)) {
						//方法为空时，默认为方法quartzMain
						method = "quartzMain";
					}
					String concurrent = rs.getString("concurrent");
					String state = rs.getString("state");
					if (StringUtils.isEmpty(jobname)
							|| StringUtils.isEmpty(triggername)
							|| StringUtils.isEmpty(cronexpression)
							|| StringUtils.isEmpty(isbean)
							|| StringUtils.isEmpty(targetobject)
							|| StringUtils.isEmpty(method)
							|| StringUtils.isEmpty(concurrent)
							|| StringUtils.isEmpty(state)) {//定时任务计划属性有空字段,记录日志
						StringBuffer sb = new StringBuffer();
						//任务名称
						sb.append("jobname:" + jobname + " ");
						//时间表达式
						sb.append("cronexpression:" + cronexpression + " ");
						//是否为bean
						sb.append("isbean:" + isbean + " ");
						//任务对象
						sb.append("targetobject:" + targetobject + " ");
						//任务方法
						sb.append("method:" + method + " ");
						//是否并发
						sb.append("concurrent:" + concurrent + " ");
						//状态
						sb.append("state:" + state);
						//输出错误日志
						log.error("错误的计划任务信息:" + sb.toString());
					} else {//合理定时任务计划新增至list
						QuartzModel qm = new QuartzModel();
						//实体属性设置
						//任务名称
						qm.setJobname(jobname);
						//时间表达式
						qm.setCronexpression(cronexpression);
						//是否为bean
						qm.setIsbean(isbean);
						//任务对象
						qm.setTargetobject(targetobject);
						//任务方法
						qm.setMethod(method);
						//是否并发
						qm.setConcurrent(concurrent);
						//状态
						qm.setState(state);
						list.add(qm);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("加载数据库计划任务信息失败:" + e.getMessage());
		} finally {
			JdbcUtils.close(rs, smt, con);
		}
		return list;
	}

	/**
	 *<pre>
	 * 方法体说明：初始化任务
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:57:35
	 * @param qm:任务实体
	 * @return
	 *</pre>
	 */
	private boolean initJob(QuartzModel qm) {
		boolean tag = false;
		try {
			// 获取容器中存在的trigger定时器
			CronTriggerBean cronTrigger = (CronTriggerBean) scheduler
					.getTrigger(qm.getId() + "Trigger",
							Scheduler.DEFAULT_GROUP);
			// 若任务存在,调用任务变更方法
			if (cronTrigger != null) {
				update(qm, cronTrigger);
			} else {
				// 若不存在，且数据库中的状态为可用时，创建任务
				if (qm.getState().equals("1")) {
					create(qm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("初始化任务失败:" + e.getMessage());
		}
		return tag;
	}

	/**
	 *<pre>
	 * 方法体说明：变更任务
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:57:45
	 * @param qm:任务实体
	 * @param cronTrigger:时间表达式对象
	 * @throws Exception:异常抛出
	 *</pre>
	 */
	private void update(QuartzModel qm, CronTriggerBean cronTrigger)
			throws Exception {
		// 先从scheduler中删除
		delete(qm, cronTrigger);
		if (qm.getState().equals("1")) {// 任务为启用时
			create(qm);
		}
	}

	/**
	 *<pre>
	 * 方法体说明：移除任务
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:57:56
	 * @param qm:任务实体
	 * @param cronTrigger:时间表达式对象
	 * @throws Exception:异常抛出
	 *</pre>
	 */
	private void delete(QuartzModel qm, CronTriggerBean cronTrigger)
			throws Exception {
		// 停止任务触发器
		scheduler.pauseTrigger(cronTrigger.getName(), cronTrigger.getGroup());
		// 移除任务触发器
		scheduler.unscheduleJob(cronTrigger.getName(), cronTrigger.getGroup());
		// 移除任务
		scheduler
				.deleteJob(cronTrigger.getJobName(), cronTrigger.getJobGroup());
	}

	/**
	 *<pre>
	 * 方法体说明：创建任务
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:58:56
	 * @param qm:任务实体
	 * @throws Exception:异常
	 *</pre>
	 */
	private void create(QuartzModel qm) throws Exception {
		// 新建一个基于spring的job管理类
		MethodInvokingJobDetailFactoryBean mijdfb = new MethodInvokingJobDetailFactoryBean();
		mijdfb.setName(qm.getId());
		// 若定义的任务为spring的bean，则调用getBean方法获得
		if (qm.getIsbean().equals("1")) {
			mijdfb.setTargetObject(beanFactory.getBean(qm.getTargetobject()));
		} else {// 类的动态创建
			mijdfb.setTargetObject(Class.forName(qm.getTargetobject())
					.newInstance());
		}
		mijdfb.setTargetMethod(qm.getMethod());
		// 设置是否并发启动任务
		mijdfb.setConcurrent(qm.getConcurrent().equals("1") ? true : false);
		// 将管理Job类提交到计划管理类
		mijdfb.afterPropertiesSet();
		// 将Spring的管理Job类转为Quartz管理Job类
		JobDetail jd = new JobDetail();
		jd = (JobDetail) mijdfb.getObject();
		jd.setName(qm.getId());
		// 将Job添加到管理类
		scheduler.addJob(jd, true);
		// 新建spring时间类
		String triggerName = qm.getId() + "Trigger";
		CronTriggerBean ctb = new CronTriggerBean();
		//时间表达式名称
		ctb.setName(triggerName);
		//时间表达式所属任务id
		ctb.setJobDetail(jd);
		//时间表达式参数
		ctb.setCronExpression(qm.getCronexpression());
		//时间表达式所属任务名称
		ctb.setJobName(qm.getId());
		// 注入到管理类
		scheduler.scheduleJob(ctb);
		// 刷新管理类
		scheduler.rescheduleJob(triggerName, Scheduler.DEFAULT_GROUP, ctb);

		log.info(new Date() + "创建任务:" + qm.getJobname() + " 任务时间:"
				+ triggerName + " " + qm.getCronexpression());
	}


	/**
	 * scheduler字段的getter方法
	 * @return 返回 scheduler字段的值
	 */
	public Scheduler getScheduler() {
		return scheduler;
	}

	/**
	 * scheduler字段的setter方法
	 * @param scheduler 为 scheduler 字段设置的值
	 */
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	/**
	 * beanFactory字段的getter方法
	 * @return 返回 beanFactory字段的值
	 */
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	/**
	 * beanFactory字段的setter方法
	 * @param beanFactory 为 beanFactory 字段设置的值
	 */
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

}
