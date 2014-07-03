package com.deppon.fssc.module.quartz.server.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.deppon.foss.framework.server.web.action.AbstractAction;
import com.deppon.foss.framework.server.web.message.IMessageBundle;
import com.deppon.fssc.module.quartz.common.model.Msg;
import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.common.model.QuartzModelName;
import com.deppon.fssc.module.quartz.common.util.QuartzUtils;
import com.deppon.fssc.module.quartz.server.service.IQuartzModelService;

/**
 * <pre>
 * 功能:任务计划管理的WEB接入层
 * action层的定位:
 * 	1.Struts2中Action是核心内容，它包含了对用户请求的处理逻辑，
 * 		我们也称Action为业务控制器。
 * 	2.Struts2中的Action采用了低侵入式的设计，
 * 		Struts2不要求Action类继承任何的Struts2的基类或实现Struts2接口。
 * 		(但是，我们为了方便实现Action，大多数情况下都会继承com.opensymphony.xwork2.ActionSupport类，
 * 		并重写此类里的public String execute() throws Exception方法。
 * 		因为此类中实现了很多的实用接口，提供了很多默认方法，
 * 		这些默认方法包括获取国际化信息的方法、数据校验的方法、默认的处理用户请求的方法等，
 * 		这样可以大大的简化Action的开发。)
 * 	3.Struts2中通常直接使用Action来封装HTTP请求参数，因此，
 * 		Action类里还应该包含与请求参数对应的属性，并且为属性提供对应的getter和setter方法。
 * 		(当然，Action类中还可以封装处理结果，把处理结果信息当作一属性，提供对应的getter和setter方法)
 * 	4.Action里只做和页面相关的事，不操作业务对象
 * 作者：谢玉良
 * 日期：2013-4-8下午3:31:07
 * </pre>
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class QuartzModelAction extends AbstractAction {

	/**
	 * 分页-每页数目
	 */
	private int limit;
	/**
	 * 分页的开始页
	 */
	private int start;
	/**
	 * 记录总数
	 */
	private Long totalCount;

	/**
	 * 注入国际化类messageBundle
	 */
	@Resource
	private IMessageBundle messageBundle;

	/**
	 * 注入quartzModelService
	 */
	@Resource
	private IQuartzModelService quartzModelService;

	/**
	 * 任务实体id
	 */
	private String quartzModelId;
	
	/**
	 * 任务名称实体id
	 */
	private String quartzModelNameId;

	/**
	 * 返回信息
	 */
	private String message;

	/**
	 * 任务实体
	 */
	private QuartzModel quartzModel;

	/**
	 * 任务名称实体
	 */
	private QuartzModelName quartzModelName;

	/**
	 * 任务计划列表
	 */
	private List<QuartzModel> quartzModelList;

	/**
	 * 任务名称列表
	 */
	private List<QuartzModelName> quartzModelNameList;

	/**
	 * 
	 * <pre>
	 * 方法体说明：跳转至任务名称管理界面
	 * 作者：谢玉良
	 * 日期： 2013-4-8 上午11:26:31
	 * @return
	 * </pre>
	 */
	public String nameIndex() {
		return SUCCESS;
	}

	/**
	 * 
	 *<pre>
	 * 方法体说明：查找所有的定时任务计划信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:16:00
	 * @return
	 *</pre>
	 */
	public String findAllQuartzModel() {
		// 获取数据库定时任务计划记录,并进行分页
		quartzModelList = quartzModelService
				.queryAll(quartzModel, limit, start);
		//获取数据库定时任务计划记录的总数
		totalCount = quartzModelService.count(quartzModel);
		return SUCCESS;
	}

	/**
	 * 
	 *<pre>
	 * 方法体说明：查找所有的定时任务计划信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:15:53
	 * @return
	 *</pre>
	 */
	public String findAllQuartzModelName() {
		// 获取数据库定时任务计划记录,并进行分页
		quartzModelNameList = quartzModelService.queryAll(quartzModelName,
				limit, start);
		//获取数据库定时任务计划记录的总数
		totalCount = quartzModelService.count(quartzModelName);
		return SUCCESS;
	}
	/**
	 * 
	 *<pre>
	 * 方法体说明：任务名称下拉列表
	 * 作者：谢玉良
	 * 日期： 2013-4-12 下午2:28:30
	 * @return
	 *</pre>
	 */
	public String gainAllQuartzModelName() {
		//设置查询为启用的任务名称
		quartzModelName=new QuartzModelName();
		//设置查询条件,1为启用，0为禁用
		quartzModelName.setState("1");
		//获取数据库任务名称数据列表
		quartzModelNameList = quartzModelService.queryAll(quartzModelName);
		return SUCCESS;
	}

	/**
	 * 
	 *<pre>
	 * 方法体说明：保存定时任务计划信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:15:47
	 * @return
	 *</pre>
	 */
	public String saveQuartzModel() {
		// 利用工具类新增数据库和quartz容器的任务
		Msg msg = QuartzUtils.addJob(quartzModel);
		if (msg.isSuccess()) {// 添加成功
			// 国际化信息设置
			message = messageBundle.getMessage(getLocale(),
					"info.module.quartz.saveSuccess");
			setSuccess(true);
		} else {// 添加失败
			//失败信息设置
			message = msg.getMessage();
			//失败信息设置
			setSuccess(false);
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 *<pre>
	 * 方法体说明：保存任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:27:12
	 * @return
	 *</pre>
	 */
	public String saveQuartzModelName() {
		try{
			//保存任务名称信息
			quartzModelService.add(quartzModelName);
			//保存成功信息设置
			message="保存成功";
		}catch(Exception e){
			//保存失败信息设置
			message=e.getMessage();
			//保存失败信息设置
			this.setSuccess(false);
		}
		return SUCCESS;
	}

	/**
	 * 
	 *<pre>
	 * 方法体说明：删除定时任务计划信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:34:00
	 * @return
	 *</pre>
	 */
	public String deleteQuartzModel() {
		// 利用工具类删除数据库和quartz容器的任务
		Msg msg = QuartzUtils.deleteJob(quartzModelId);
		if (msg.isSuccess()) {// 删除成功
			// 国际化信息提示设置
			message = messageBundle.getMessage(getLocale(),
					"info.module.quartz.deleteSuccess");
			setSuccess(true);
		} else {// 删除失败
			message = msg.getMessage();
			setSuccess(false);
		}
		return SUCCESS;
	}

	/**
	 * 
	 *<pre>
	 * 方法体说明：更新定时任务计划信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:35:45
	 * @return
	 *</pre>
	 */
	public String updateQuartzModel() {
		// 利用工具类更新数据库和quartz容器的任务
		Msg msg = QuartzUtils.changeJob(quartzModel);
		if (msg.isSuccess()) {// 更新成功
			// 国际化信息提示
			message = messageBundle.getMessage(getLocale(),
					"info.module.quartz.updateSuccess");
			setSuccess(true);
		} else {// 更新失败
			message = msg.getMessage();
			setSuccess(false);
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 *<pre>
	 * 方法体说明：更新任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:36:01
	 * @return
	 *</pre>
	 */
	public String updateQuartzModelName() {
		try {
			//任务名称信息保存
			quartzModelService.update(quartzModelName);
			//保存成功设置
			message="保存成功";
		} catch (Exception e) {
			//保存失败设置
			message=e.getMessage();
		}
		return SUCCESS;
	}

	/**
	 * 获取运行的任务记录
	 */
	public String lookRunJob() {
		quartzModelList = QuartzUtils.lookRunJob();
		return SUCCESS;
	}

	/**
	 * @param quartzModelId
	 *            the quartzModelId to set
	 */
	public void setQuartzModelId(String quartzModelId) {
		this.quartzModelId = quartzModelId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the quartzModel
	 */
	public QuartzModel getQuartzModel() {
		return quartzModel;
	}

	/**
	 * @param quartzModel
	 *            the quartzModel to set
	 */
	public void setQuartzModel(QuartzModel quartzModel) {
		this.quartzModel = quartzModel;
	}

	/**
	 * @return the quartzModelName
	 */
	public QuartzModelName getQuartzModelName() {
		return quartzModelName;
	}

	/**
	 * @param quartzModelName
	 *            the quartzModelName to set
	 */
	public void setQuartzModelName(QuartzModelName quartzModelName) {
		this.quartzModelName = quartzModelName;
	}

	/**
	 * @return the quartzModelList
	 */
	public List<QuartzModel> getQuartzModelList() {
		return quartzModelList;
	}

	/**
	 * @return the quartzModelNameList
	 */
	public List<QuartzModelName> getQuartzModelNameList() {
		return quartzModelNameList;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/**
	 * @return the quartzModelNameId
	 */
	public String getQuartzModelNameId() {
		return quartzModelNameId;
	}

	/**
	 * @param quartzModelNameId the quartzModelNameId to set
	 */
	public void setQuartzModelNameId(String quartzModelNameId) {
		this.quartzModelNameId = quartzModelNameId;
	}

}
