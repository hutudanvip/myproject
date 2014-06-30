package com.student.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.student.dao.ITermDao;
import com.student.domain.Term;
import com.student.services.IGradeService;
import com.student.services.ITermService;

public class TermServiceImpl implements ITermService {
	
	private ITermDao termDao;
	
	private IGradeService gradeService;

	public IGradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(IGradeService gradeService) {
		this.gradeService = gradeService;
	}

	public ITermDao getTermDao() {
		return termDao;
	}

	public void setTermDao(ITermDao termDao) {
		this.termDao = termDao;
	}

	
	public List<Term> selectAll() {
		return termDao.selectAll();
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-16
	 * description:新增新的学期时，会将所有的有效学期设置为无效，并作废所有有效的年级
	 * param:
	 */
	@Required
	
	public void insert(Term term) {
		//先作废之前的学期
		this.repeal();
		
		//作废所有有效的年级
		gradeService.repealAll();
		
		//增加新学期
		termDao.insert(term);
	}

	
	public void delete(String id) {
		termDao.delete(id);
	}

	
	public void update(Term term) {
		termDao.update(term);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-16
	 * description:新增新的学期时，会将所有的有效学期设置为无效
	 * param:
	 */
	
	public void repeal() {
		termDao.repeal();
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-16
	 * description:查询有效版本的学期
	 * param:
	 */
	
	public Term selectEffect() {
		Term term = new Term();
		term = termDao.selectEffect();
		return term;
	}
}
