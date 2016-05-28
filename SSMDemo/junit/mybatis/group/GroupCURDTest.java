package mybatis.group;


import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springmvc_demo.dao.GroupDao;
import org.springmvc_demo.dao.impl.GroupDaoImpl;
import org.springmvc_demo.entity.Employe;
import org.springmvc_demo.entity.Group;

public class GroupCURDTest {

	static ApplicationContext app ;
	static GroupDao<Group, Integer> ss ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		app = new ClassPathXmlApplicationContext("applicationDataSource.xml","applicationContext.xml");
		ss = (GroupDaoImpl) app.getBean("groupDao");
	}

	@Test
	public void add()throws Exception{
		System.out.println( ss.add(new Group("开发组1")) );
	}
	
	@Test
	public void addBatch()throws Exception{
		List<Group> grouplist = new ArrayList<Group>();
		grouplist.add(new Group("开发组3"));
		grouplist.add(new Group("开发组4"));
		grouplist.add(new Group("开发组5"));
		grouplist.add(new Group("研发组1"));
		grouplist.add(new Group("研发组2"));
		grouplist.add(new Group("测试组1"));
		grouplist.add(new Group("测试组2"));
		ss.addBatch(grouplist);
	}
	
	//一对多查询
	@Test
	public void findById() throws Exception{
		
		Group g = ss.findById(1);
		System.out.println( g.getGroupName());
		
		List<Employe> emplist = g.getEmplist();
		for (Employe employe : emplist) {
			System.out.println( employe.toString());
		}
	}
}
