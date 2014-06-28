package domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.action.StudentAction;
import com.student.dao.IStudentDao;
import com.student.dao.impl.StudentDaoImpl;
import com.student.domain.Grades;
import com.student.domain.Student;
import com.student.domain.Term;
import com.student.services.IStudentService;
import com.student.utils.DateUtils;


public class StudentTest extends TestCase{
	
//	String[] str = {"WEB-INF/applicationContext-base.xml","applicationContext-student.xml"};
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-base.xml");
	IStudentDao dao = (IStudentDao)ctx.getBean("studentDao");
	IStudentService ser = (IStudentService)ctx.getBean("studentService");
//	SqlSessionTemplate sqlSession = (SqlSessionTemplate) ctx.getBean("sqlSessionTemplate");
	StudentAction action = (StudentAction) ctx.getBean("studentAction");
	
	@Test
	public void testStudent(){
		Grades grade = new Grades();
		grade.setId("478ef57f-acb2-11e2-b7e2-2fc13debe2ac");
		
		Student s = new Student();
		Grades g = new Grades();
		g.setId("10da48cf-c2b4-11e2-8170-83ddca5d732a");
		
		Term term = new Term();
		term.setId("17");
		
		s.setGrade(g);
		s.setTerm(term);
		s.setQueryType("in");
		s.setBeginTime(DateUtils.getMonthFirstDay(new Timestamp(new Date().getTime())));
		s.setEndTime(DateUtils.getNextMonthFirstDay(new Timestamp(new Date().getTime())));
	
		
//		s.setNumber("001");
//		s.setName("0002");
//		s.setAddress("sdffffffffff");
//		s.setAge(20);
//		s.setCellphone("13917445214");
//		s.setGender(0);
//		s.setGenearchName("张三");
//		s.setGrade(grade);
//		s.setIntime(new Date());
//		s.setNum("1");
//		s.setRelation("爸爸2222222");
//		s.setIseffective(true);
//		s.setDescribe("啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		
//		List<Student> list = ser.query(s);
//		s = list.get(0);
//		
//		for(int i=0; i< list.size(); i++)
//		{
//			System.out.println(s.getName());
//			
//		}
//		
//		String num = "008";
//		Student stu = new Student();
//		stu.setName("bbbbbbbbbbbbbbbb");
//		stu.setNum(num);
//		
////		ser.add(stu);
//
//		ser.modify(stu);
//		List<Student> list = ser.query(num);
//		
//		
//		if(list != null
//				&& list.size() > 0)
//		{
//			s = list.get(0);
//			
//			System.out.println(s.getName());
//		}
	}
}
