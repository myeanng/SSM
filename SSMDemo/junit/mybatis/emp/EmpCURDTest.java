package mybatis.emp;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springmvc_demo.dao.EmployeDao;
import org.springmvc_demo.dao.impl.EmpDaoImpl;
import org.springmvc_demo.entity.Employe;
import org.springmvc_demo.entity.Group;


public class EmpCURDTest {

	static ApplicationContext app ;
	static EmployeDao<Employe, Integer> ss ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		app = new ClassPathXmlApplicationContext("applicationDataSource.xml","applicationContext.xml");
		ss = (EmpDaoImpl) app.getBean("empDao");
	}
	
	//通过雇员ID查询单个雇员信息和所属的组信息
	@Test
	public void findById()throws Exception{
		Employe emp = ss.findById(1);
		System.out.println(emp.getGroup().toString());
		System.out.println( emp.toString());
	}
	
	//通过组ID查询该组的所有雇员的信息(包括组信息)
	@Test
	public void findEntityListByParam()throws Exception{
		List<Employe> emplist = ss.findEntityListByParam(1);
		for (Employe employe : emplist) {
			System.out.println( employe.toString() );
		}
	}
	
	//添加单条数据，注意组的值是在这个时候插入的
	@Test
	public void add() throws Throwable{
		Group g = new Group();
		g.setGroupId(2);
		Employe emp = new Employe("七七","qi@kaifengfu.com", g);
		ss.add(emp);
	}
}
