package com.student.services.impl;

import java.util.List;

import com.student.dao.IGradesDao;
import com.student.domain.Grades;
import com.student.services.IGradeService;

public class GradeServiceImpl implements IGradeService {
	
	private IGradesDao gradeDao;

	public IGradesDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(IGradesDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-23
	 * description:查询所有年级，包含无效数据
	 * param:
	 */
	public List<Grades> selectAll() {
		return gradeDao.selectAll();
	}

	public void insert(Grades grades) {
		gradeDao.insert(grades);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-23
	 * description:作废年级，作废时先检查该年级下是否存在有效的学生，若存在，则不能作废
	 * param:
	 */
	public void delete(String id) {
		gradeDao.delete(id);
	}

	public void update(Grades grade) {
		gradeDao.update(grade);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-23
	 * description:检查该年级下是否有有效的学生，用于年级作废，若存在，则不能作废
	 * param:
	 */
	public int isExistStudent(String id) {
		return gradeDao.isExistStudent(id);
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-23
	 * description:作废所有有效的年级
	 * param:
	 */
	public void repealAll() {
		gradeDao.repealAll();
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-23
	 * description:查询所有有效的年级
	 * param:
	 */
	public List<Grades> selectAllEffect() {
		return gradeDao.selectAllEffect();
	}

}
