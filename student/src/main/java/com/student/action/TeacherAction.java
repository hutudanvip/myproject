package com.student.action;

import java.util.List;

import com.student.domain.Teacher;
import com.student.services.ITeacherService;

public class TeacherAction extends BaseAction{
	
	public boolean success;

	public List<Teacher> list;
	
	public Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Teacher> getList() {
		return list;
	}
	public void setList(List<Teacher> list) {
		this.list = list;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:添加教师
	 * param:
	 */
	public String add()
	{
		if(teacher != null)
		{
			teacherService.insert(teacher);
			
			this.success = true;
		}
		return SUCCESS;
	}
	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:查询所有教师
	 * param:
	 */
	public String query()
	{
		list = teacherService.selectAll();
		
		this.success = true;
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:查询所有有效教师
	 * param:
	 */
	public String queryEffect()
	{
		list = teacherService.selectAllEffect();
		
		this.success = true;
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:作废教师
	 * param:
	 */
	public void repeal()
	{
		if(teacher != null)
		{
			String id = teacher.getId();
			if(id != null && !"".equals(id))
			{
				teacherService.repeal(id);
				this.success = true;
			}
		}
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-6-1
	 * description:修改教师数据
	 * param:
	 */
	public String update(){
		if(teacher != null){
			teacherService.update(teacher);
			this.success = true;
			return SUCCESS;
		}
		else{
			this.success = false;
			return ERROR;
		}
	}
}
