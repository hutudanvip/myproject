package com.student.action;

import com.student.utils.ExcelUtils;

public class FileAction extends BaseAction {
	
	boolean success;
	
	String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String add()
	{
		System.out.println("file upload...........");
		System.out.println(filePath);
		if(filePath != null
				&& !"".equals(filePath.toString().trim()))
		{
			//excel导入
			ExcelUtils.readExcel(filePath);
		}
		else
		{
//			System.out.println("文件路径获取失败！");
		}
		return "success";
	}
}
