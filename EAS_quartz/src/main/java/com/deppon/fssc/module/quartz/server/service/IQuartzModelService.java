package com.deppon.fssc.module.quartz.server.service;

import java.util.List;

import com.deppon.foss.framework.service.IService;
import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.common.model.QuartzModelName;

public interface IQuartzModelService extends IService {

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数获取定时任务计划记录
	 * service层的定位：
	 * 	1.Service不依赖于任何表现技术，不操纵任务用于表现的对象，
	 * 		对于业务对象，尤其是跨多个业务对象的操作，要放到Service里面来;
	 * 	2.Service层主要负责业务模块的逻辑应用设计。
	 * 		同样是首先设计接口，再设计其实现的类，
	 * 		接着再Spring的配置文件中配置其实现的关联。
	 * 		这样我们就可以在应用中调用Service接口来进行业务处理。
	 * 		Service层的业务实现，具体要调用到已定义的DAO层的接口，
	 * 		封装Service层的业务逻辑有利于通用的业务逻辑的独立性和重复利用性，程序显得非常简洁。
	 * 	3.Service层是建立在DAO层之上的，建立了DAO层后才可以建立Service层，
	 * 		而Service层又是在action层之下的，因而Service层应该既调用DAO层的接口，
	 * 		又要提供接口给action层的类来进行调用，它刚好处于一个中间层的位置。
	 * 		每个模型都有一个Service接口，每个接口分别封装各自的业务处理方法。 
	 * 作者：谢玉良
	 * 日期： 2013-4-8 下午3:49:00
	 * @param quartzModel:查询参数
	 * @return
	 * </pre>
	 */
	List<QuartzModel> queryAll(QuartzModel quartzModel);

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数获取任务名称记录
	 * 作者：谢玉良
	 * 日期： 2013-4-8 下午3:49:00
	 * @param quartzModelName:查询参数
	 * @return
	 * </pre>
	 */
	List<QuartzModelName> queryAll(QuartzModelName quartzModelName);

	/**
	 * 
	 *<pre>
	 * 方法体说明：新增定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:13:06
	 * @param quartzModel
	 *</pre>
	 */
	void add(QuartzModel quartzModel);

	/**
	 * 
	 *<pre>
	 * 方法体说明：更新定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:14:06
	 * @param quartzModel
	 *</pre>
	 */
	void update(QuartzModel quartzModel);

	/**
	 * 
	 *<pre>
	 * 方法体说明：删除定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:14:21
	 * @param id
	 *</pre>
	 */
	void removeById(String id);

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数查询定时任务计划记录并分页
	 * 作者：谢玉良
	 * 日期： 2013-4-8 下午3:47:57
	 * @param quartzModel:查询参数
	 * @param limit:每页记录数
	 * @param start:起始页
	 * @return
	 * </pre>
	 */
	List<QuartzModel> queryAll(QuartzModel quartzModel, int limit, int start);

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数查询任务名称记录并分页
	 * 作者：谢玉良
	 * 日期： 2013-4-8 下午3:47:57
	 * @param quartzModel:查询参数
	 * @param limit:每页记录数
	 * @param start:起始页
	 * @return
	 * </pre>
	 */
	List<QuartzModelName> queryAll(QuartzModelName quartzModelName, int limit,
			int start);

	/**
	 * 
	 *<pre>
	 * 方法体说明：根据model参数统计任务计划记录数
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:15:03
	 * @param quartzModel
	 * @return
	 *</pre>
	 */
	Long count(QuartzModel quartzModel);

	/**
	 *<pre>
	 * 方法体说明：根据model参数统计任务名称记录数
	 * 作者：谢玉良
	 * 日期： 2013-4-8 下午3:50:42
	 * @param quartzModelName
	 * @return
	 *</pre>
	 */
	Long count(QuartzModelName quartzModelName);

	/**
	 *<pre>
	 * 方法体说明：保存任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:29:18
	 * @param quartzModelName
	 *</pre>
	 * @throws Exception 
	 */
	void add(QuartzModelName quartzModelName) throws Exception;

	/**
	 *<pre>
	 * 方法体说明：更新任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:36:40
	 * @param quartzModelName
	 *</pre>
	 * @throws Exception 
	 */
	void update(QuartzModelName quartzModelName) throws Exception;
}
