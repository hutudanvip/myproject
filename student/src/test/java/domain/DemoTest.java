package domain;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.student.domain.Student;

public class DemoTest {
	public void export(){
		
		List<Student> stuList = new ArrayList<Student>();
		
		Student s = new Student();
		s.setName("aaa");
		s.setNumber("111");
		stuList.add(s);
		
		s.setName("bbb");
		s.setNumber("222");
		stuList.add(s);
		

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
			Short s1 = Short.valueOf("1");
			HSSFCell cell0 = row.createCell((short)0);
			HSSFCell cell1 = row.createCell(Short.valueOf("1"));
			
			//设置字符集
			cell0.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
			
			cell0.setCellValue("学号");
			cell1.setCellValue("姓名");
			
			for (int i=0; i<stuList.size(); i++) {
				Student stu = stuList.get(i);
				
				System.out.println(stu.getName());
				
				row = sheet.createRow(i+1);
				cell0 = row.createCell(Short.valueOf("0"));
				cell1 = row.createCell(Short.valueOf("1"));
				
				//设置字符集
				cell0.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
				
				cell0.setCellValue(stu.getNumber());
				cell1.setCellValue(stu.getName());
				
				sheet.setColumnWidth((short)0, (short)4000);
				sheet.setColumnWidth((short)1, (short)4000);
			}

			//通过Response把数据以Excel格式保存
			HttpServletResponse response = ServletActionContext.getResponse();
			response.reset();
			
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition", "attachment;filename=\""
						+ new String(("学生查询结果" + ".xls").getBytes("GBK"),
								"ISO8859_1") + "\"");
				OutputStream out = response.getOutputStream();
				workBook.write(out);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		DemoTest dt = new DemoTest();
		dt.export();
	}
}
