package domain;

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
import com.student.services.IGradeService;
import com.student.services.IStudentService;
import com.student.services.ITermService;


public class TermTest extends TestCase{
	
//	String[] str = {"WEB-INF/applicationContext-base.xml","applicationContext-student.xml"};
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-base.xml");
	ITermService service = (ITermService)ctx.getBean("termService");
	
	@Test
	public void testGrade(){
		Term t = new Term();
		t = service.selectEffect();
//		g.setId("432fdb3d-ab29-11e2-bb3f-3d7bb4154c3f");
//		g.setName("bbbbbbbbbbbbbbbbbb");
		
//		System.out.println(t.getName());
//		t.setName("0000");
//		t.setNumber("201302");
//		t.setBeginTime(new Date());
//		t.setDescribe("ttttt");
//		t.setId("14");
//		
//		service.update(t);
	}
}
