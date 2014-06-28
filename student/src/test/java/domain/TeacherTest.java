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
import com.student.domain.Teacher;
import com.student.services.IGradeService;
import com.student.services.IStudentService;
import com.student.services.ITeacherService;


public class TeacherTest extends TestCase{
	
//	String[] str = {"WEB-INF/applicationContext-base.xml","applicationContext-student.xml"};
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-base.xml");
	ITeacherService service = (ITeacherService)ctx.getBean("teacherService");
	
	@Test
	public void testGrade(){
		Teacher t = new Teacher();
		t.setName("ll");
		t.setId("a8f6046a-d703-11e2-a782-f1bad2ea22e8");
		t.setNumber("001");
		t.setDescribe("test");
		t.setInTime(new Date());
		
		service.repeal("a8f6046a-d703-11e2-a782-f1bad2ea22e8");
//		g.setName("bbbbbbbbbbbbbbbbbb");
		
//		List<Grades> list = service.selectAll();
//		
//		g = list.get(0);
//		g.setDescribe("aaaaaaaaaaaaaaaaaaaa");
//		service.insert(g);
//		List<Grades> list = service.selectAll(false);
//		System.out.println(list.size());
	}
}
