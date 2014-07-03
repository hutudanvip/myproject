package com.deppon.fssc.module.quartz.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jgroups.util.UUID;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.module.authorization.shared.domain.UserEntity;
import com.deppon.fssc.module.quartz.common.model.Msg;
import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.server.dao.IQuartzModelDao;

/**
 * <pre>
 * 功能:定时计划任务动态管理工具类
 *工具类的定位：
 *	1.作为一个软件开发者，缺乏想象力是最严重的罪过之一。
 *		我们经常把事情重复做一遍又一遍，但是我们很少改变这种方式。
 *		经过这些年开发，在我的工具箱里面有了一些每个项目我都需要用到的工具，
 *		烦人的重复工作不再是我的事.
 *	2.工具，汉语词语，原指工作时所需用的器具，
 *		后引申为为达到、完成或促进某一事物的手段。
 *		它的好处可以是机械性，也可以是智能性的。
 *		大部分工具都是简单机械。
 *		例如一根铁棍可以当作槓杆使用，力点离开支点越远，杠杆传递的力就越大.
 *		而工具类就是通过实现独立功能单元的一个工具
 *	3.直接使用的工具类，不但可以在本应用中使用这些工具类，也可以在其它的应用中使用，
 *		这些工具类中的大部分是可以在脱离各种框架和应用时使用的。
 *		工具类并在程序编写时适当使用和提取，将有助于提高开发效率、增强代码质量。
 *	4.对于软件开发过程中，需要使用到各种框架，而框架中往往都提供了相应的工具类。
 *		比如spring、struts、ibatis、hibernate。
 *		而java本身也提供不少的工具类供开发员进行特殊的处理
 * 作者：谢玉良
 * 日期：2013-7-25上午11:14:43
 * </pre>
 */
public class QuartzUtils {
	// 私有构造方法
	private QuartzUtils() {
	}

	// 任务model
	private static IQuartzModelDao quartzModelDao;

	// 日志对象
	private static Logger log = Logger.getLogger(QuartzUtils.class);
	// 对应的bean是schedulerManager由spring配置文件注入
	private static Scheduler scheduler;
	// spring应用容器
	private static WebApplicationContext wac = ContextLoader
			.getCurrentWebApplicationContext();

	/**
	 * <pre>
	 * 功能:定时计划任务必备的管理接口实例化
	 * 作者：谢玉良
	 * 日期：2013-7-25上午11:14:43
	 * </pre>
	 */
	static {
		// quartz调度对象
		if (scheduler == null) {
			// 获取实例化对象
			Object obj = getBean("schedulerManager");
			// 赋值
			scheduler = (Scheduler) obj;
		}
		// 任务model
		if (quartzModelDao == null) {
			// 获取model实例化对象
			Object obj = getBean("quartzModelDao");
			// 赋值
			quartzModelDao = (IQuartzModelDao) obj;
		}
	}

	/**
	 * <pre>
	 * 方法体说明：获取bean对象
	 * 作者：谢玉良
	 * 日期： 2013-7-25 上午11:17:20
	 * @param beanName:bean名字
	 * @return
	 * </pre>
	 */
	private static Object getBean(String beanName) {
		// 定义对象
		Object obj = null;
		try {
			// 从spring应用容器中获取对象
			obj = wac.getBean(beanName);
		} catch (Exception e) {
			// 异常打印
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * <pre>
	 * 方法体说明：检查model是否合法
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:55:00
	 * @param qm
	 * @throws Exception
	 * </pre>
	 */
	private static void checkQuartzModel(QuartzModel qm) throws Exception {
		if (qm == null) {
			throw new Exception("错误的计划任务信息:计划为空");
		}
		// 任务名称
		String jobname = qm.getJobname();
		// 时间表达式
		String cronexpression = qm.getCronexpression();
		// 是否为bean
		String isbean = qm.getIsbean();
		// 目标类
		String targetobject = qm.getTargetobject();
		// 目标方法
		String method = qm.getMethod();
		// 是否同步
		String concurrent = qm.getConcurrent();
		// 是否启用
		String state = qm.getState();
		if (StringUtils.isEmpty(jobname) || StringUtils.isEmpty(cronexpression)
				|| StringUtils.isEmpty(isbean)
				|| StringUtils.isEmpty(targetobject)
				|| StringUtils.isEmpty(method)
				|| StringUtils.isEmpty(concurrent)
				|| StringUtils.isEmpty(state)) {
			// 日志信息拼接
			StringBuffer sb = new StringBuffer();
			sb.append("jobname:" + jobname + " ");
			sb.append("cronexpression:" + cronexpression + " ");
			sb.append("isbean:" + isbean + " ");
			sb.append("targetobject:" + targetobject + " ");
			sb.append("method:" + method + " ");
			sb.append("concurrent:" + concurrent + " ");
			sb.append("state:" + state);
			log.error("错误的计划任务信息:" + sb.toString());
			throw new Exception("错误的计划任务信息:" + sb.toString());
		}
		// 判断任务名称是否已被使用
		// if (!StringUtils.isBlank(qm.getId())) {
		if (quartzModelDao.countByJobid(qm) > 0) {
			throw new Exception("该任务名称的任务项已存在");
		}
		// }
		// 判断任务是否已存在
		if (isExist(qm)) {
			throw new Exception("已存在的任务对象和任务方法");
		}

		// 判断任务名称是否启用
		if (qm.getState().equals("1")) {
			if (quartzModelDao.countByJobidAndState(qm) > 0) {
				throw new Exception("该任务项的任务名称未启用.");
			}
		}
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据类及方法名判断是否存在任务
	 * 作者：谢玉良
	 * 日期： 2013-4-12 下午6:04:51
	 * @param qm
	 * @return
	 * </pre>
	 */
	private static boolean isExist(QuartzModel qm) {
		boolean res = false;
		// 同一类中的同一方法不可重复的校验
		if (qm.getId() != null && !(qm.getId().equals(""))) {
			// 更新操作,判断方法是否变更，变更了的方法是否已注册
			QuartzModel qm1Query = new QuartzModel();
			qm1Query.setId(qm.getId());
			// 根据id查找出数据库中的任务
			QuartzModel qmtemp = quartzModelDao.queryAll(qm1Query).get(0);
			// 根据查找任务与页面的任务进行异同的判断(类+方法名)
			if (!(qmtemp.getTargetobject().equals(qm.getTargetobject()) && qmtemp
					.getMethod().equals(qm.getMethod()))) {// 变更了方法
				QuartzModel qmQuery = new QuartzModel();
				qmQuery.setTargetobject(qm.getTargetobject());
				qmQuery.setMethod(qm.getMethod());
				// 根据新的任务类与方法，判断是否已存在
				int tag = quartzModelDao.getByTargetAndMethod(qmQuery);
				if (tag > 0) {
					res = true;
				}
			}
		} else {// 插入操作,判断新增的方法是否已注册
			// 任务对象定义
			QuartzModel qmQuery = new QuartzModel();
			// 目标对象设置
			qmQuery.setTargetobject(qm.getTargetobject());
			// 目标方法设置
			qmQuery.setMethod(qm.getMethod());
			int tag = quartzModelDao.getByTargetAndMethod(qmQuery);
			if (tag > 0) {
				res = true;
			}
		}

		return res;
	}

	/**
	 * <pre>
	 * 方法体说明：修改数据库的定时计划任务
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:54:48
	 * @param qm
	 * @throws Exception
	 * </pre>
	 */
	private static void updateJob(QuartzModel qm) throws Exception {
		// 获取登录用户
		IUser user = UserContext.getCurrentUser();
		// 设置操作人id
		qm.setOperator(user.getId());
		// 设置操作人姓名
		qm.setOperatorname(((UserEntity) user).getEmpCode().getEmpName());
		quartzModelDao.update(qm);
	}

	/**
	 * <pre>
	 * 方法体说明：删除数据库的定时计划任务
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:54:39
	 * @param id
	 * @throws Exception
	 * </pre>
	 */
	private static void removeJob(String id) throws Exception {
		quartzModelDao.deleteById(id);
	}

	/**
	 * <pre>
	 * 方法体说明：删除定时计划任务并但不未除数据库数据
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:54:28
	 * @param id
	 * </pre>
	 */
	private static void deleteQuartzJob(String id) {
		try {
			String triggerName = id + "Trigger";
			CronTriggerBean cronTrigger = (CronTriggerBean) scheduler
					.getTrigger(triggerName, Scheduler.DEFAULT_GROUP);
			if (cronTrigger != null) {
				// 停止任务触发器
				scheduler.pauseTrigger(cronTrigger.getName(),
						cronTrigger.getGroup());
				// 移除任务触发器
				scheduler.unscheduleJob(cronTrigger.getName(),
						cronTrigger.getGroup());
				// 移除任务
				scheduler.deleteJob(cronTrigger.getJobName(),
						cronTrigger.getJobGroup());
			}
			log.info(new Date() + "删除任务:" + id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：异常信息处理类
	 * 作者：谢玉良
	 * 日期： 2013-4-12 下午5:05:44
	 * @param e
	 * @return
	 * </pre>
	 */
	private static String Exception(Exception e) {
		String msg = "";
		if (e.getCause() != null) {
			if (e.getCause().getClass().equals(ClassNotFoundException.class)) {// 找不到相应的类
				msg = "不存在的类";
			} else if (e.getCause().getClass()
					.equals(NoSuchBeanDefinitionException.class)) {// 找不到相应的bean
				msg = "不存在的bean";
			} else if (e.getCause().getClass()
					.equals(NoSuchMethodException.class)) {
				msg = "不存在的方法";
			} else {// 其他特殊情况
				msg = e.toString();
			}
		} else {// 其他特殊情况
			msg = e.toString();
		}
		return msg;
	}

	/**
	 * <pre>
	 * 方法体说明：新增定时计划任务并保存至数据库
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:54:16
	 * @param qm
	 * @return
	 * </pre>
	 */
	public static Msg addJob(QuartzModel qm) {
		Msg msg = new Msg();
		try {
			// 检查qm是否合法
			checkQuartzModel(qm);
			try {
				// 设置qm主键，也为定时任务的唯一标识
				String id = "" + UUID.randomUUID();
				qm.setId(id);
				// 新建一个基于spring的job管理类
				MethodInvokingJobDetailFactoryBean mijdfb = new MethodInvokingJobDetailFactoryBean();
				mijdfb.setName(id);
				// 若定义的任务为spring的bean，则调用getBean方法获得
				if (qm.getIsbean().equals("1")) {
					mijdfb.setTargetObject(wac.getBean(qm.getTargetobject()));
				} else {// 类的动态创建
					mijdfb.setTargetObject(Class.forName(qm.getTargetobject())
							.newInstance());
				}
				mijdfb.setTargetMethod(qm.getMethod());
				// 设置是否并发启动任务
				mijdfb.setConcurrent(qm.getConcurrent().equals("1") ? true
						: false);
				// 将管理Job类提交到计划管理类
				mijdfb.afterPropertiesSet();
				// 将Spring的管理Job类转为Quartz管理Job类
				JobDetail jd = new JobDetail();
				jd = (JobDetail) mijdfb.getObject();
				jd.setName(id);
				// 将Job添加到管理类
				scheduler.addJob(jd, true);
				// 新建spring时间类
				String triggerName = id + "Trigger";
				CronTriggerBean ctb = new CronTriggerBean();
				ctb.setName(triggerName);
				ctb.setJobDetail(jd);
				ctb.setCronExpression(qm.getCronexpression());
				ctb.setJobName(id);
				// 注入到管理类
				scheduler.scheduleJob(ctb);
				// 刷新管理类
				scheduler.rescheduleJob(triggerName, Scheduler.DEFAULT_GROUP,
						ctb);

				log.info(new Date() + "创建任务:" + qm.getJobname() + " 任务时间:"
						+ triggerName + " " + qm.getCronexpression());
				msg.setMessage(new Date() + "创建任务成功:" + qm.getJobname()
						+ " 任务时间:" + triggerName + " " + qm.getCronexpression());

				// 保存至数据库
				// 获取登录用户
				IUser user = UserContext.getCurrentUser();
				// 设置操作人id
				qm.setOperator(user.getId());
				// 设置操作人姓名
				qm.setOperatorname(((UserEntity) user).getEmpCode()
						.getEmpName());
				quartzModelDao.insert(qm);
			} catch (Exception e) {
				deleteQuartzJob(qm.getId());// 失败了必须将注入的任务删除
				e.printStackTrace();
				throw new Exception(e);
			}
			msg.setSuccess(true);
		} catch (Exception e) {
			// 调用异常处理公共方法处理
			msg.setMessage(Exception(e));
			log.error(e);
			msg.setSuccess(false);
		}
		return msg;
	}

	/**
	 * <pre>
	 * 方法体说明：更新定时计划任务并保存至数据库
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:54:04
	 * @param qm
	 * @return
	 * </pre>
	 */
	public static Msg changeJob(QuartzModel qm) {
		Msg msg = new Msg();
		try {
			// 检查qm是否合法
			checkQuartzModel(qm);

			String triggerName = qm.getId() + "Trigger";
			CronTriggerBean cronTrigger = (CronTriggerBean) scheduler
					.getTrigger(triggerName, Scheduler.DEFAULT_GROUP);

			if (cronTrigger != null) {
				// ----------首先丛scheuler中移除任务------------------
				// 停止任务触发器
				scheduler.pauseTrigger(cronTrigger.getName(),
						cronTrigger.getGroup());
				// 移除任务触发器
				scheduler.unscheduleJob(cronTrigger.getName(),
						cronTrigger.getGroup());
				// 移除任务
				scheduler.deleteJob(cronTrigger.getJobName(),
						cronTrigger.getJobGroup());
				// -------------------移除完毕-------------------------
			}

			if (qm.getState().equals("1")) {// 任务为启用时
				// 新建一个基于spring的job管理类
				MethodInvokingJobDetailFactoryBean mijdfb = new MethodInvokingJobDetailFactoryBean();
				mijdfb.setName(qm.getId());
				// 若定义的任务为spring的bean，则调用getBean方法获得
				if (qm.getIsbean().equals("1")) {
					mijdfb.setTargetObject(wac.getBean(qm.getTargetobject()));
				} else {// 类的动态创建
					mijdfb.setTargetObject(Class.forName(qm.getTargetobject())
							.newInstance());
				}
				mijdfb.setTargetMethod(qm.getMethod());
				// 设置是否并发启动任务
				mijdfb.setConcurrent(qm.getConcurrent().equals("1") ? true
						: false);
				// 将管理Job类提交到计划管理类
				mijdfb.afterPropertiesSet();
				// 将Spring的管理Job类转为Quartz管理Job类
				JobDetail jd = new JobDetail();
				jd = (JobDetail) mijdfb.getObject();
				jd.setName(qm.getId());
				// 将Job添加到管理类
				scheduler.addJob(jd, true);
				// 新建spring时间类
				CronTriggerBean ctb = new CronTriggerBean();
				ctb.setName(triggerName);
				ctb.setJobDetail(jd);
				ctb.setCronExpression(qm.getCronexpression());
				ctb.setJobName(qm.getId());
				// 注入到管理类
				scheduler.scheduleJob(ctb);
				// 刷新管理类
				scheduler.rescheduleJob(triggerName, Scheduler.DEFAULT_GROUP,
						ctb);

				log.info(new Date() + "创建任务:" + qm.getJobname() + " 任务时间:"
						+ triggerName + " " + qm.getCronexpression());
				msg.setMessage(new Date() + "创建任务成功:" + qm.getJobname()
						+ " 任务时间:" + triggerName + " " + qm.getCronexpression());
			}
			// 保存至数据库
			updateJob(qm);
			msg.setSuccess(true);
		} catch (Exception e) {
			// 调用异常处理公共方法处理
			msg.setMessage(Exception(e));
			log.error(e.getMessage());
			msg.setSuccess(false);
		}
		return msg;
	}

	/**
	 * <pre>
	 * 方法体说明：删除定时计划任务并移除数据库数据
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:53:52
	 * @param id
	 * @return
	 * </pre>
	 */
	public static Msg deleteJob(String id) {
		Msg msg = new Msg();
		try {
			deleteQuartzJob(id);

			// 删除数据库数据
			removeJob(id);

			msg.setSuccess(true);
		} catch (Exception e) {
			log.error(e.getMessage());
			msg.setMessage("操作失败");
			msg.setSuccess(false);
		}
		return msg;
	}

	/**
	 * <pre>
	 * 方法体说明：查看运行中的jobname
	 * 作者：谢玉良
	 * 日期： 2013-7-25 下午1:53:25
	 * @return
	 * </pre>
	 */
	public static List<QuartzModel> lookRunJob() {
		List<QuartzModel> list = new ArrayList<QuartzModel>();
		try {
			StringBuffer sb = new StringBuffer("(");
			String[] strs = scheduler.getJobNames(Scheduler.DEFAULT_GROUP);
			for (int i = 0; i < strs.length; i++) {
				if (i == 0) {
					sb.append("'" + strs[i] + "'");
				} else {
					sb.append("," + "'" + strs[i] + "'");
				}
			}
			sb.append(")");
			list = quartzModelDao.getIn(sb.toString());
		} catch (Exception e) {
		}
		return list;
	}
}
