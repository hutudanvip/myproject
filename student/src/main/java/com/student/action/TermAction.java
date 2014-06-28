package com.student.action;

import java.util.List;

import com.student.domain.Term;

public class TermAction extends BaseAction {
	
	public boolean success;
	
	public List<Term> listTerm;
	
	public Term term;
	
	public String state;

	public List<Term> getListTerm() {
		return listTerm;
	}

	public void setListTerm(List<Term> listTerm) {
		this.listTerm = listTerm;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	/**
	 * 
	 * author:afei
	 * date:2013-4-22
	 * description:查询所有学期
	 * param:
	 */
	public String query()
	{
		System.out.println("sdfsdffffffffffffffffffffff");
		listTerm = termService.selectAll();
		this.success = true;
		return SUCCESS;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-5-16
	 * description:查询有效版本的学期，用于学生新增界面
	 * param:
	 */
	public String select()
	{
		System.out.println("ttttttttttttttttttttttttttttttt");
		term = termService.selectEffect();
		this.success = true;
		return SUCCESS;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-4-25
	 * description:增加
	 * param:
	 */
	public String add()
	{
		if(term != null
				&& !"".equals(term.toString().trim()))
		{
			if(state != null && "add".equals(state))
			{
				termService.insert(term);
				this.success = true;
			}
			else
			{
				this.modify();
			}
			return SUCCESS;
		}
		else
		{
			this.success = false;
			return ERROR;
		}
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-4-25
	 * description:修改
	 * param:
	 */
	public String modify()
	{
		termService.update(term);
		this.success = true;
		return SUCCESS;
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-4-25
	 * description:删除
	 * param:
	 */
	public String delete()
	{
		if(term != null)
		{
			termService.delete(term.getId().toString());
			this.success = true;
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	
}
