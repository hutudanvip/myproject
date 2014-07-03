package com.deppon.fssc.module.quartz.server.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.exception.GeneralException;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.module.authorization.shared.domain.UserEntity;
import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.common.model.QuartzModelName;
import com.deppon.fssc.module.quartz.server.dao.IQuartzModelDao;
import com.deppon.fssc.module.quartz.server.exception.QuartzModelException;
import com.deppon.fssc.module.quartz.server.exception.QuartzModelExceptionType;
import com.deppon.fssc.module.quartz.server.service.IQuartzModelService;

/**
 *<pre>
 *功能:定时任务service实现层
 * dao层的定位：
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
 *日期：2013-7-26下午12:01:23
 *</pre>
 */
@Transactional(readOnly = true)
@Service
public class QuartzModelService implements IQuartzModelService {

	/**
	 * 定时任务DAO实例
	 */
	@Resource
	private IQuartzModelDao quartzModelDao;

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数获取定时任务计划记录
	 * 作者：谢玉良
	 * 日期： 2013-4-8 下午3:49:00
	 * @param quartzModel:查询参数
	 * @return
	 * </pre>
	 */
	@Override
	public List<QuartzModel> queryAll(QuartzModel quartzModel) {
		return quartzModelDao.queryAll(quartzModel);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：新增定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:13:06
	 * @param quartzModel
	 * </pre>
	 */
	@SuppressWarnings("serial")
	@Transactional
	@Override
	public void add(QuartzModel quartzModel) {
		if (quartzModel == null) {
			QuartzModelException e = new QuartzModelException(
					QuartzModelExceptionType.IsNull);
			throw new GeneralException(e.getErrorCode(), e.getMessage(), e,
					new Object[] {}) {
			};
		}
		// 获取登录用户
		IUser user = UserContext.getCurrentUser();
		// 设置操作人id
		quartzModel.setOperator(user.getId());
		// 设置操作人姓名
		quartzModel.setOperatorname(((UserEntity)user).getEmpCode().getEmpName());
		quartzModelDao.insert(quartzModel);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：更新定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:14:06
	 * @param quartzModel
	 * </pre>
	 */
	@SuppressWarnings("serial")
	@Transactional
	@Override
	public void update(QuartzModel quartzModel) {
		//参数判断及异常抛出
		if (quartzModel == null) {
			QuartzModelException e = new QuartzModelException(
					QuartzModelExceptionType.IsNull);
			throw new GeneralException(e.getErrorCode(), e.getMessage(), e,
					new Object[] {}) {
			};
		}
		// 获取登录用户
		IUser user = UserContext.getCurrentUser();
		// 设置操作人id
		quartzModel.setOperator(user.getId());
		// 设置操作人姓名
		quartzModel.setOperatorname(((UserEntity)user).getEmpCode().getEmpName());
		quartzModelDao.update(quartzModel);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：删除定时任务计划
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:14:21
	 * @param id
	 * </pre>
	 */
	@SuppressWarnings("serial")
	@Transactional
	@Override
	public void removeById(String quartzModelId) {
		//参数判断及异常抛出
		if (quartzModelId == null || "".equals(quartzModelId.trim())) {
			QuartzModelException e = new QuartzModelException(
					QuartzModelExceptionType.IdNull);
			throw new GeneralException(e.getErrorCode(), e.getMessage(), e,
					new Object[] {}) {
			};
		}
		quartzModelDao.deleteById(quartzModelId);
	}

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
	@Override
	public List<QuartzModel> queryAll(QuartzModel quartzModel, int limit,
			int start) {
		return quartzModelDao.getAll(quartzModel, limit, start);
	}

	/**
	 * 
	 * <pre>
	 * 方法体说明：根据model参数统计任务计划记录数
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:15:03
	 * @param quartzModel
	 * @return
	 * </pre>
	 */
	@Override
	public Long count(QuartzModel quartzModel) {
		return quartzModelDao.count(quartzModel);
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
	public List<QuartzModelName> queryAll(QuartzModelName quartzModelName) {
		return quartzModelDao.getAll(quartzModelName);
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
	public List<QuartzModelName> queryAll(QuartzModelName quartzModelName,
			int limit, int start) {
		return quartzModelDao.getAll(quartzModelName, limit, start);
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
		return quartzModelDao.count(quartzModelName);
	}

	/**
	 * <pre>
	 * 方法体说明：保存任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:29:18
	 * @param quartzModelName
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("serial")
	@Override
	public void add(QuartzModelName quartzModelName) throws Exception {
		//参数判断及异常抛出
		if (quartzModelName == null
				|| StringUtils.isBlank(quartzModelName.getJobname())) {
			QuartzModelException e = new QuartzModelException(
					QuartzModelExceptionType.IsNull);
			throw new GeneralException(e.getErrorCode(), e.getMessage(), e,
					new Object[] {}) {
			};
		}
		// 判断任务名称是否已存在
		Long count = quartzModelDao.countByJobname(quartzModelName);
		if (count > 0) {
			throw new Exception("已存在的任务名称");
		}
		// 获取登录用户
		IUser user = UserContext.getCurrentUser();
		if (StringUtils.isBlank(quartzModelName.getDes())) {
			quartzModelName.setDes("");
		}
		quartzModelName.setId("" + UUID.randomUUID());
		// 设置操作人id
		quartzModelName.setOperator(user.getId());
		// 设置操作人姓名
		quartzModelName.setOperatorname(((UserEntity)user).getEmpCode().getEmpName());
		quartzModelDao.insert(quartzModelName);
	}

	/**
	 * <pre>
	 * 方法体说明：更新任务名称信息
	 * 作者：谢玉良
	 * 日期： 2013-4-10 下午3:36:40
	 * @param quartzModelName
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void update(QuartzModelName quartzModelName) throws Exception {
		// 判断任务名称是否已存在
		Long count = quartzModelDao.countByJobname(quartzModelName);
		if (count > 0) {
			throw new Exception("已存在的任务名称");
		}
		// 获取登录用户
		IUser user = UserContext.getCurrentUser();
		if (StringUtils.isBlank(quartzModelName.getDes())) {
			quartzModelName.setDes("");
		}
		// 设置操作人id
		quartzModelName.setOperator(user.getId());
		// 设置操作人姓名
		quartzModelName.setOperatorname(((UserEntity)user).getEmpCode().getEmpName());

		// 判断该任务名称是否已被使用,被使用时不允许禁用
		if (quartzModelName.getState().equals("0")) {
			QuartzModel qm = new QuartzModel();
			qm.setJobid(quartzModelName.getId());
			qm.setState("1");
			List<QuartzModel> list = quartzModelDao.queryAll(qm);
			if (list != null && list.size() > 0) {
				throw new Exception("该任务名称下存在启用的任务项，不可禁用.");
			}
		}
		// 更新任务名称
		quartzModelDao.update(quartzModelName);
		// 更新任务信息中的任务名称
		quartzModelDao.updateByJobid(quartzModelName);
	}

}
