package com.deppon.fssc.module.quartz.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.common.model.QuartzModelName;
import com.deppon.fssc.module.quartz.server.dao.IQuartzModelDao;

/**
 * 
 * <pre>
 * 功能:定时任务计划Dao实现层
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
 * 作者：谢玉良
 * 日期：2013-4-10下午3:10:44
 * </pre>
 */
@SuppressWarnings("unchecked")
@Repository
public class QuartzModelDao extends iBatis3DaoImpl implements IQuartzModelDao {
	/**
	 *  对于系统后台需要从其他系统
	 *  中同步数据的
	 *  （如用户信息、部门信息等）
	 *  自动定时任务,
	 *  在后台任务管理里面配置其是否启用,
	 *  可以进行调节同步的时间节点;
	 *  将报账系统涉及到从其他系统同步数据的接口任务进行管理，
	 *  可以对同步接口任务名称进行新增和修改;
	 */
	
	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数获取任务信息列表
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:10:31
	 * @param quartzModel
	 * @return
	 * </pre>
	 */
	@Override
	public List<QuartzModel> queryAll(QuartzModel quartzModel) {
		List<QuartzModel> list = null;
		//查询条件的判断及拼接
		QuartzModel model = new QuartzModel();
		if (quartzModel != null) {
			if (quartzModel.getId() != null && !"".equals(quartzModel.getId())) {
				model.setId(quartzModel.getId());
			}
			if (quartzModel.getJobid() != null
					&& !"".equals(quartzModel.getJobid())) {
				model.setJobid(quartzModel.getJobid());
			}
			if (quartzModel.getCronexpression() != null
					&& !"".equals(quartzModel.getCronexpression())) {
				String cronexpression = "%" + quartzModel.getCronexpression()
						+ "%";
				model.setCronexpression(cronexpression);
			}
			if (quartzModel.getIsbean() != null
					&& !"".equals(quartzModel.getIsbean())) {
				String isbean = quartzModel.getIsbean();
				model.setIsbean(isbean);
			}
			if (quartzModel.getTargetobject() != null
					&& !"".equals(quartzModel.getTargetobject())) {
				String targetobject = "%" + quartzModel.getTargetobject() + "%";
				model.setTargetobject(targetobject);
			}
			if (quartzModel.getMethod() != null
					&& !"".equals(quartzModel.getMethod())) {
				String method = "%" + quartzModel.getMethod() + "%";
				model.setMethod(method);
			}
			if (quartzModel.getConcurrent() != null
					&& !"".equals(quartzModel.getConcurrent())) {
				String concurrent = quartzModel.getConcurrent();
				model.setConcurrent(concurrent);
			}
			if (quartzModel.getState() != null
					&& !"".equals(quartzModel.getState())) {
				String state = quartzModel.getState();
				model.setState(state);
			}
		}
		list = getSqlSession()
				.selectList(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.getAll",
						model);
		return list;
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：更新定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:01:54
	 * @param quartzModel
	 * </pre>
	 */
	@Override
	public void update(QuartzModel quartzModel) {
		if (StringUtils.isBlank(quartzModel.getDes())) {
			quartzModel.setDes("");
		}
		getSqlSession()
				.update("com.deppon.fssc.module.quartz.common.model.QuartzModel.update",
						quartzModel);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：新增定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:01:39
	 * @param quartzModel
	 * </pre>
	 */
	@Override
	public void insert(QuartzModel quartzModel) {
		if (StringUtils.isBlank(quartzModel.getDes())) {
			quartzModel.setDes("");
		}
		getSqlSession()
				.insert("com.deppon.fssc.module.quartz.common.model.QuartzModel.insert",
						quartzModel);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据id删除定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:01:26
	 * @param id
	 * </pre>
	 */
	@Override
	public void deleteById(String id) {
		getSqlSession()
				.delete("com.deppon.fssc.module.quartz.common.model.QuartzModel.deleteById",
						id);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数获取定时任务计划并分页
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:59:54
	 * @param quartzModel:查询参数
	 * @param limit:每页记录数
	 * @param start:起始页
	 * @return
	 * </pre>
	 */
	@Override
	public List<QuartzModel> getAll(QuartzModel quartzModel, int limit,
			int start) {
		RowBounds rowBounds = new RowBounds(start, limit);
		List<QuartzModel> list = null;
		//查询条件的判断及拼接
		QuartzModel model = new QuartzModel();
		if (quartzModel != null) {
			if (quartzModel.getId() != null && !"".equals(quartzModel.getId())) {
				model.setId(quartzModel.getId());
			}
			if (quartzModel.getJobid() != null
					&& !"".equals(quartzModel.getJobid())) {
				model.setJobid(quartzModel.getJobid());
			}
			if (quartzModel.getCronexpression() != null
					&& !"".equals(quartzModel.getCronexpression())) {
				String cronexpression = "%" + quartzModel.getCronexpression()
						+ "%";
				model.setCronexpression(cronexpression);
			}
			if (quartzModel.getIsbean() != null
					&& !"".equals(quartzModel.getIsbean())) {
				String isbean = quartzModel.getIsbean();
				model.setIsbean(isbean);
			}
			if (quartzModel.getTargetobject() != null
					&& !"".equals(quartzModel.getTargetobject())) {
				String targetobject = "%" + quartzModel.getTargetobject() + "%";
				model.setTargetobject(targetobject);
			}
			if (quartzModel.getMethod() != null
					&& !"".equals(quartzModel.getMethod())) {
				String method = "%" + quartzModel.getMethod() + "%";
				model.setMethod(method);
			}
			if (quartzModel.getConcurrent() != null
					&& !"".equals(quartzModel.getConcurrent())) {
				String concurrent = quartzModel.getConcurrent();
				model.setConcurrent(concurrent);
			}
			if (quartzModel.getState() != null
					&& !"".equals(quartzModel.getState())) {
				String state = quartzModel.getState();
				model.setState(state);
			}
		}
		list = getSqlSession()
				.selectList(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.getAll",
						model, rowBounds);
		return list;
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：(方法详细描述说明、方法参数的具体涵义)
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:59:36
	 * @param quartzModel
	 * @return
	 * </pre>
	 */
	@Override
	public Long count(QuartzModel quartzModel) {
		QuartzModel model = new QuartzModel();
		if (quartzModel != null) {
			if (quartzModel.getId() != null && !"".equals(quartzModel.getId())) {
				model.setId(quartzModel.getId());
			}
			if (quartzModel.getJobid() != null
					&& !"".equals(quartzModel.getJobid())) {
				model.setJobid(quartzModel.getJobid());
			}
			if (quartzModel.getCronexpression() != null
					&& !"".equals(quartzModel.getCronexpression())) {
				String cronexpression = "%" + quartzModel.getCronexpression()
						+ "%";
				model.setCronexpression(cronexpression);
			}
			if (quartzModel.getIsbean() != null
					&& !"".equals(quartzModel.getIsbean())) {
				String isbean = quartzModel.getIsbean();
				model.setIsbean(isbean);
			}
			if (quartzModel.getTargetobject() != null
					&& !"".equals(quartzModel.getTargetobject())) {
				String targetobject = "%" + quartzModel.getTargetobject() + "%";
				model.setTargetobject(targetobject);
			}
			if (quartzModel.getMethod() != null
					&& !"".equals(quartzModel.getMethod())) {
				String method = "%" + quartzModel.getMethod() + "%";
				model.setMethod(method);
			}
			if (quartzModel.getConcurrent() != null
					&& !"".equals(quartzModel.getConcurrent())) {
				String concurrent = quartzModel.getConcurrent();
				model.setConcurrent(concurrent);
			}
			if (quartzModel.getState() != null
					&& !"".equals(quartzModel.getState())) {
				String state = quartzModel.getState();
				model.setState(state);
			}
		}
		Long count = (Long) getSqlSession().selectOne(
				"com.deppon.fssc.module.quartz.common.model.QuartzModel.count",
				model);
		return count;
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：通过任务名称获取定时任务计划信息信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:59:14
	 * @param jobname
	 * @return
	 * </pre>
	 */
	@Override
	public List<QuartzModel> getIn(String jobname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", jobname);
		return getSqlSession().selectList(
				"com.deppon.fssc.module.quartz.common.model.QuartzModel.getIn",
				map);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：通过任务对象和任务方法查找
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午2:57:54
	 * @param qmQuery
	 * @return
	 * </pre>
	 */
	@Override
	public int getByTargetAndMethod(QuartzModel qmQuery) {
		int count = (Integer) getSqlSession()
				.selectOne(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.countByTargetAndMethod",
						qmQuery);
		return count;
	}

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
	@Override
	public List<QuartzModelName> getAll(QuartzModelName quartzModelName) {
		List<QuartzModelName> list = null;
		//查询条件的判断及拼接
		//1、	输入对应的任务名称
		//2、	选择该任务名称是否启用
		//3、	输入备注信息，非必填
		//4、	保存的时候需校验必填项是否已填，
		//		且必须判断该任务名称是否已经添加过（在系统存在），
		//		如果不同时满足以上则不允许保存，保存时，
		//		自动记录操作人和操作时间
		//		（操作人获取当前登录人工号对应的名字，
		//		操作时间获取对应保存时服务器的时间）
		QuartzModelName model = new QuartzModelName();
		if (quartzModelName != null) {
			if (quartzModelName.getId() != null
					&& !"".equals(quartzModelName.getId())) {
				model.setId(quartzModelName.getId());
			}
			if (quartzModelName.getJobname() != null
					&& !"".equals(quartzModelName.getJobname())) {
				model.setJobname("%" + quartzModelName.getJobname() + "%");
			}
			if (quartzModelName.getState() != null
					&& !"".equals(quartzModelName.getState())) {
				model.setState(quartzModelName.getState());
			}
		}
		list = getSqlSession()
				.selectList(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.getAllName",
						model);
		return list;
	}

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
	@Override
	public List<QuartzModelName> getAll(QuartzModelName quartzModelName,
			int limit, int start) {
		RowBounds rowBounds = new RowBounds(start, limit);
		List<QuartzModelName> list = null;
		//查询条件的判断及拼接
		//1、	输入对应的任务名称
		//2、	选择该任务名称是否启用
		//3、	输入备注信息，非必填
		//4、	保存的时候需校验必填项是否已填，
		//		且必须判断该任务名称是否已经添加过（在系统存在），
		//		如果不同时满足以上则不允许保存，保存时，
		//		自动记录操作人和操作时间
		//		（操作人获取当前登录人工号对应的名字，
		//		操作时间获取对应保存时服务器的时间）
		QuartzModelName model = new QuartzModelName();
		if (quartzModelName != null) {
			if (quartzModelName.getJobname() != null
					&& !"".equals(quartzModelName.getJobname())) {
				String jobname = "%" + quartzModelName.getJobname() + "%";
				model.setJobname(jobname);
			}
			if (quartzModelName.getState() != null
					&& !"".equals(quartzModelName.getState())) {
				String state = quartzModelName.getState();
				model.setState(state);
			}
		}
		list = getSqlSession()
				.selectList(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.getAllName",
						model, rowBounds);
		return list;
	}

	/**
	 * <pre>
	 * 方法体说明：根据model参数统计任务名称记录数
	 * 作者：谢玉良
	 * 日期： 2013-4-8 下午3:50:42
	 * @param quartzModelName
	 * @return
	 * </pre>
	 */
	@Override
	public Long count(QuartzModelName quartzModelName) {
		//查询条件的判断及拼接
		QuartzModelName model = new QuartzModelName();
		if (quartzModelName != null) {
			if (quartzModelName.getJobname() != null
					&& !"".equals(quartzModelName.getJobname())) {
				String jobname = "%" + quartzModelName.getJobname() + "%";
				model.setJobname(jobname);
			}
			if (quartzModelName.getState() != null
					&& !"".equals(quartzModelName.getState())) {
				String state = quartzModelName.getState();
				model.setState(state);
			}
		}
		Long count = (Long) getSqlSession()
				.selectOne(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.countName",
						model);
		return count;
	}

	/**
	 * <pre>
	 * 方法体说明：保存任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:29:18
	 * @param quartzModelName
	 * </pre>
	 */
	@Override
	public void insert(QuartzModelName quartzModelName) {
		getSqlSession()
				.insert("com.deppon.fssc.module.quartz.common.model.QuartzModel.insertName",
						quartzModelName);
	}

	/**
	 * <pre>
	 * 方法体说明：更新任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:36:40
	 * @param quartzModelName
	 * </pre>
	 */
	@Override
	public void update(QuartzModelName quartzModelName) {
		getSqlSession()
				.update("com.deppon.fssc.module.quartz.common.model.QuartzModel.updateName",
						quartzModelName);
	}

	/**
	 * <pre>
	 * 方法体说明：更新任务列表中的任务名称
	 * 作者：谢玉良
	 * 日期： 2013-4-12 下午8:43:09
	 * @param quartzModelName
	 * </pre>
	 */
	@Override
	public void updateByJobid(QuartzModelName quartzModelName) {
		getSqlSession()
				.update("com.deppon.fssc.module.quartz.common.model.QuartzModel.updateByJobid",
						quartzModelName);
	}

	/**
	 * <pre>
	 * 方法体说明：根据任务名称，统计记录数
	 * 作者：谢玉良
	 * 日期： 2013-4-13 下午2:44:08
	 * @param quartzModelName
	 * @return
	 * </pre>
	 */
	@Override
	public Long countByJobname(QuartzModelName quartzModelName) {
		//查询条件的判断及拼接
		QuartzModelName model = new QuartzModelName();
		if (quartzModelName != null) {
			if (quartzModelName.getJobname() != null
					&& !"".equals(quartzModelName.getJobname())) {
				model.setJobname(quartzModelName.getJobname());
			}
			if (quartzModelName.getId() != null
					&& !"".equals(quartzModelName.getId())) {
				model.setId(quartzModelName.getId());
			}
		}
		Long count = (Long) getSqlSession()
				.selectOne(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.countJobname",
						model);
		return count;
	}

	/**
	 * <pre>
	 * 方法体说明：根据设置的任务名称id查询任务项
	 * 作者：谢玉良
	 * 日期： 2013-4-13 下午3:36:04
	 * @param qm
	 * @return
	 * </pre>
	 */
	@Override
	public Long countByJobid(QuartzModel qm) {
		//查询条件的判断及拼接
		QuartzModel model = new QuartzModel();
		if (qm != null) {
			if (qm.getJobid() != null && !"".equals(qm.getJobid())) {
				model.setJobid(qm.getJobid());
			}
			if (qm.getId() != null && !"".equals(qm.getId())) {
				model.setId(qm.getId());
			}
		}
		Long count = (Long) getSqlSession()
				.selectOne(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.countByJobid",
						model);
		return count;
	}

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
	public Long countByJobidAndState(QuartzModel qm) {
		//查询条件的判断及拼接
		QuartzModel model = new QuartzModel();
		if (qm != null) {
			if (qm.getJobid() != null && !"".equals(qm.getJobid())) {
				model.setJobid(qm.getJobid());
			}
		}
		Long count = (Long) getSqlSession()
				.selectOne(
						"com.deppon.fssc.module.quartz.common.model.QuartzModel.countByJobidAndState",
						model);
		return count;
	}

}
