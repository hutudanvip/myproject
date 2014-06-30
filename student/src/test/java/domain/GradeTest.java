package domain;

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
import com.student.services.IGradeService;
import com.student.services.IStudentService;


public class GradeTest extends TestCase{
	
//	String[] str = {"WEB-INF/applicationContext-base.xml","applicationContext-student.xml"};
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-base.xml");
	IGradeService service = (IGradeService)ctx.getBean("gradeService");
	
	@Test
	public void testGrade(){
		Grades g = new Grades();
		g.setName("00");
		g.setNumber("00");
		g.setId("432fdb3d-ab29-11e2-bb3f-3d7bb4154c3f");
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
