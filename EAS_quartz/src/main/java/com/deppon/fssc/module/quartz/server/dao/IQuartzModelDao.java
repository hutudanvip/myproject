package com.deppon.fssc.module.quartz.server.dao;

import java.util.List;

import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.common.model.QuartzModelName;

/**
 * 
 *<pre>
 *功能:定时任务计划Dao层
 *dao层的定位：
 *	1.单纯的业务对象的存取，组装放到DAO里完成
 *	2.DAO层主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此，
 *		DAO层的设计首先是设计DAO的接口，然后在Spring的配置文件中定义此接口的实现类，
 *		然后就可在模块中调用此接口来进行数据业务的处理，
 *		而不用关心此接口的具体实现类是哪个类，显得结构非常清晰，
 *		DAO层的数据源配置，以及有关数据库连接的参数都在Spring的配置文件中进行配置。 
 *	3.在DAO层定义的一些方法，在Service层并没有使用，
 *		那为什么还要在DAO层进行定义呢？这是由我们定义的需求逻辑所决定的。
 *		DAO层的操作 经过抽象后基本上都是通用的，
 *		因而我们在定义DAO层的时候可以将相关的方法定义完毕，
 *		这样的好处是在对Service进行扩展的时候不需要再对DAO层进行修改，提高了程序的可扩展性。
 *	4.DAO层所定义的接口里的方法都大同小异，
 *		这是由我们在DAO层对数据库访问的操作来决定的，
 *		对数据库的操作，我们基本要用到的就是新增，更新，删除，查询等方法。
 *		因而DAO层里面基本上都应该要涵盖这些方法对应的操作。
 *		除此之外，可以定义一些自定义的特殊的对数据库访问的方法。
 *作者：谢玉良
 *日期：2013-4-10下午3:10:44
 *</pre>
 */
public interface IQuartzModelDao {
	/**
	 * 
	 *<pre>
	 * 方法体说明：根据model参数获取任务信息列表
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:10:31
	 * @param quartzModel
	 * @return
	 *</pre>
	 */
	List<QuartzModel> queryAll(QuartzModel quartzModel);

	/**
	 * 
	 *<pre>
	 * 方法体说明：更新定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:01:54
	 * @param quartzModel
	 *</pre>
	 */
	void update(QuartzModel quartzModel);

	/**
	 * 
	 *<pre>
	 * 方法体说明：新增定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:01:39
	 * @param quartzModel
	 *</pre>
	 */
	void insert(QuartzModel quartzModel);

	/**
	 * 
	 *<pre>
	 * 方法体说明：根据id删除定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:01:26
	 * @param id
	 *</pre>
	 */
	void deleteById(String id);

	/**
	 * 
	 *<pre>
	 * 方法体说明：根据model参数获取定时任务计划并分页
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:59:54
	 * @param quartzModel:查询参数
	 * @param limit:每页记录数
	 * @param start:起始页
	 * @return
	 *</pre>
	 */
	List<QuartzModel> getAll(QuartzModel quartzModel, int limit, int start);

	/**
	 * 
	 *<pre>
	 * 方法体说明：(方法详细描述说明、方法参数的具体涵义)
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:59:36
	 * @param quartzModel
	 * @return
	 *</pre>
	 */
	Long count(QuartzModel quartzModel);

	/**
	 * 
	 *<pre>
	 * 方法体说明：通过任务名称获取定时任务计划信息信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:59:14
	 * @param jobname
	 * @return
	 *</pre>
	 */
	List<QuartzModel> getIn(String jobname);

	/**
	 * 
	 *<pre>
	 * 方法体说明：通过任务对象和任务方法查找
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:57:54
	 * @param qmQuery
	 * @return
	 *</pre>
	 */
	int getByTargetAndMethod(QuartzModel qmQuery);

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
	List<QuartzModelName> getAll(QuartzModelName quartzModelName);

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
	List<QuartzModelName> getAll(QuartzModelName quartzModelName, int limit,
			int start);

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
	 */
	void insert(QuartzModelName quartzModelName);

	/**
	 *<pre>
	 * 方法体说明：更新任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:36:40
	 * @param quartzModelName
	 *</pre>
	 */
	void update(QuartzModelName quartzModelName);

	/**
	 *<pre>
	 * 方法体说明：更新任务列表中的任务名称
	 * 作者：谢玉良
	 * 日期： 2013-4-12 下午8:43:09
	 * @param quartzModelName
	 *</pre>
	 */
	void updateByJobid(QuartzModelName quartzModelName);

	/**
	 *<pre>
	 * 方法体说明：根据任务名称，统计记录数
	 * 作者：谢玉良
	 * 日期： 2013-4-13 下午2:44:08
	 * @param quartzModelName
	 * @return
	 *</pre>
	 */
	Long countByJobname(QuartzModelName quartzModelName);

	/**
	 *<pre>
	 * 方法体说明：根据设置的任务名称id查询任务项
	 * 作者：谢玉良
	 * 日期： 2013-4-13 下午3:36:04
	 * @param qm
	 * @return
	 *</pre>
	 */
	Long countByJobid(QuartzModel qm);
	
	/**
	 * 
	 *<pre>
	 * 方法体说明：根据设置的任务名称id查询已启用任务名称
	 * 作者：谢玉良
	 * 日期： 2013-5-2 下午5:12:56
	 * @param qm
	 * @return
	 *</pre>
	 */
	Long countByJobidAndState(QuartzModel qm);

}
