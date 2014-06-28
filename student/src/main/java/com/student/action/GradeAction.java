package com.student.action;

import java.util.List;

import com.student.domain.Grades;

public class GradeAction extends BaseAction {

	public boolean success;

	public List<Grades> listGrade;

	public Grades grade;

	public String state;

	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Grades getGrade() {
		return grade;
	}

	public void setGrade(Grades grade) {
		this.grade = grade;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Grades> getListGrade() {
		return listGrade;
	}

	public void setListGrade(List<Grades> listGrade) {
		this.listGrade = listGrade;
	}

	/**
	 * 
	 * author:afei
	 * date:2013-5-23
	 * description:查询年级    true 查询所有记录 ；     
	 * param:
	 */
	public String query() {
		listGrade = gradeService.selectAll();
		this.success = true;
		return SUCCESS;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-5-23
	 * description:查询有效记录      false查询所有有效的记录
	 * param:
	 */
	public String queryEffect() {
		listGrade = gradeService.selectAllEffect();
		this.success = true;
		return SUCCESS;
	}

	/**
	 * 
	 * author:afei date:2013-4-25 description:增加 param:
	 */
	public String add() {
		if (grade != null && !"".equals(grade.toString().trim())) {
			System.out.println(grade.getId().toString());
			if (state != null && "add".equals(state)) {
				gradeService.insert(grade);
				this.success = true;
			} else {
				this.modify();
			}
			return SUCCESS;
		} else {
			this.success = false;
			return ERROR;
		}
	}

	/**
	 * 
	 * author:afei date:2013-4-25 description:修改 param:
	 */
	public String modify() {
		gradeService.update(grade);
		this.success = true;
		return SUCCESS;
	}

	/**
	 * 
	 * author:afei date:2013-4-25 description:作废年级，该年级下存在有效的学生则不能作废。 param:
	 */
	public String repeal() {
		message = "";
		if (grade != null) {
			// 作废前先判断该年级下是否存在有效的学生，存在则不能作废
			int count = gradeService.isExistStudent(grade.getId().toString());
			if (count > 0) {
//				message = "该年级下存在有效的学生，所以不能作废！";
				
				this.success = false;
				return ERROR;
			} else {
				gradeService.delete(grade.getId().toString());
				this.success = true;
				return SUCCESS;
			}
		} else {
			message = "传入的参数为空！";
			
			this.success = false;
			return ERROR;
		}
	}

}
