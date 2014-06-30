package com.student.action;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

import com.student.domain.Student;
import com.student.utils.DateUtils;

public class StudentAction extends BaseAction {
	
	private Student student;
	
	private boolean success;
	
	public List<Student> stuList;
	
	public String ui_sate;
	
	public String getUi_sate() {
		return ui_sate;
	}

	public void setUi_sate(String ui_sate) {
		this.ui_sate = ui_sate;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * 
	 * author:afei
	 * date:2013-4-9
	 * description:新增学生
	 * param:
	 */
	public String add()
	{
		System.out.println(super.studentService);
		if(student.getNumber() != null && !"".equals(student.getNumber().toString().trim()))
		{
			if(ui_sate != null && "add".equals(ui_sate.trim()))
			{
				studentService.add(student);

				this.success = true;
			}
			else
			{
				this.modify();
			}
			
			//保存成功后清空对象的值
			student = null;
			return "success";
		}
		else
		{
			this.success = false;
			return "error";
		}

	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-5-17
	 * description:查询学生
	 * param:
	 * @throws UnsupportedEncodingException 
	 */
	public String query() throws UnsupportedEncodingException
	{
		System.out.println("this is query");
		
		if(student != null)
		{
			//设置姓名格式，解决乱码问题
			String name = student.getName();
			if(name != null && !"".equals(name.trim()))
			{
				name = new String(student.getName().getBytes("iso-8859-1"),"utf-8");
				student.setName(name);
			}
			Timestamp time = student.getBeginTime();
			if(time != null)
			{
				//设置查询的开始日期		为选择月份的第一天
				student.setBeginTime(DateUtils.getMonthFirstDay(time));
				//设置查询的结束日期		为选择月份下个月的第一天
				student.setEndTime(DateUtils.getNextMonthFirstDay(time));
			}
			
			//查询
			stuList = studentService.query(student);
			
			this.success = true;
			return SUCCESS;
		}
		else
		{
			System.out.println("传入的参数为空!");
			return ERROR;
		}
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-4-12
	 * description:修改
	 * param:
	 */
	public String modify()
	{
		if(student != null)
		{
			studentService.modify(student);
			
			this.success = true;
			return SUCCESS;
		}
		else
		{
			System.out.println("传入的学生对象为空！");
			return ERROR;
		}
	}
	
	/**
	 * 
	 * author:afei
	 * date:2013-4-28
	 * description:作废学生信息
	 * param:
	 */
	public String repeal()
	{
		if(student != null)
		{
			String id = student.getId();
			studentService.repeal(id);
			
			this.success = true;
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	
	/**
	 * 数据导出 author:afei date:2013-6-15 description: param:
	 */
	public void export() {
		if (stuList != null && stuList.size() > 0) {
			
			//新建一个excel
			HSSFWorkbook workBook = new HSSFWorkbook();
			//创建sheet页
			HSSFSheet sheet = workBook.createSheet();
			//设置sheet页名称
			workBook.setSheetName(0, "学生");
			//创建header页
			HSSFHeader header = sheet.getHeader();
			//设置标题居中
			header.setCenter("学生查询结果");
			
			//设置第一行为header
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell0 = row.createCell((short)0);
			HSSFCell cell1 = row.createCell(Short.valueOf("1"));
			HSSFCell cell2 = row.createCell(Short.valueOf("2"));
			
			//设置字符集
			cell0.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
			
			cell0.setCellValue("学号");
			cell1.setCellValue("姓名");
			cell2.setCellValue("班级");
			
			for (int i=0; i<stuList.size(); i++) {
				Student s = stuList.get(i);
				
				System.out.println(s.getName());
				
				row = sheet.createRow(i+1);
				cell0 = row.createCell(Short.valueOf("0"));
				cell1 = row.createCell(Short.valueOf("1"));
				cell2 = row.createCell(Short.valueOf("2"));
				
				//设置字符集
				cell0.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
				
				cell0.setCellValue(s.getNumber());
				cell1.setCellValue(s.getName());
				cell2.setCellValue(s.getGrade().getName());
				
				sheet.setColumnWidth((short)0, (short)4000);
				sheet.setColumnWidth((short)1, (short)4000);
			}

			//通过Response把数据以Excel格式保存
//			HttpServletResponse response = ServletActionContext.getResponse();
//			response.reset();
//			
//			response.setContentType("application/msexcel;charset=UTF-8");
//			try {
//				response.addHeader("Content-Disposition", "attachment;filename=\""
//						+ new String(("学生查询结果" + ".xls").getBytes("GBK"),
//								"ISO8859_1") + "\"");
//				OutputStream out = response.getOutputStream();
//				workBook.write(out);
//				out.flush();
//				out.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		
		this.success = true;
	}
}
