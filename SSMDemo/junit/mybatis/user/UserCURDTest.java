package mybatis.user;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springmvc_demo.dao.UserDao;
import org.springmvc_demo.dao.impl.UserDaoImpl;
import org.springmvc_demo.entity.User;
import org.springmvc_demo.service.BaseService;
import org.springmvc_demo.service.impl.UserServiceImpl;
import org.springmvc_demo.util.Page;

public class UserCURDTest {

	static ApplicationContext app ;
	static UserDao<User, Integer> ss ;
	static BaseService<User> userService ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		app = new ClassPathXmlApplicationContext("applicationDataSource.xml","applicationContext.xml");
		ss = (UserDaoImpl) app.getBean("userDao");
		userService = (UserServiceImpl) app.getBean("userService");
		System.out.println(userService.getClass().getName());
	}

	
	/**
	 * 鏌ヨUser鏁版嵁,浠ュ垎椤靛舰寮�
	 * 杩欓噷鍑虹幇鐨勫垎椤甸渶瑕佹敞鎰忎娇鐢ㄧ殑鏄痬ybatis鐨勬嫤鎴�鍣ㄦ満鍒讹紝鎷︽埅鍣ㄧ被鑷繁缂栧啓銆�
	 */
	@Test
	public void findAllByPage()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = new User();
		user.setEmail("@A.com");
		map.put("user", user);

		int count = ss.getCount(map);
		
		Page userPage = new Page(count ,1 , 10);
		map.put("page", userPage);
		
		List<User> userlist =  ss.findAllByPage(map);
		for (User u : userlist) {
			System.out.println( u.toString());
		}
	}
	
	
	//鏍规嵁ID鏌ヨUser
	@Test
	public void findById()throws Exception{
		System.out.println( ss.findById(111).toString() );
	}

	//鎻掑叆涓�潯鏂版暟鎹�
	@Test
	public void insert()throws Exception{
		User user = new User("灞曟槶" ,"zhanzhao@kaifengfu.com","yumao" , new Date());
		System.out.println( ss.add(user));
	}
	
	
	//鏇存柊
	@Test
	public void update()throws Exception{
		User zhanzhao = ss.findById(3);
		zhanzhao.setEmail("yumao@kaifengfu.com");
		System.out.println( ss.update(zhanzhao));
	}

	//鍒犻櫎鍗曟潯鏁版嵁锛岄�杩�forEach鎷兼帴
	@Test
	public void delete()throws Exception{
		System.out.println( ss.delete(3));
	}
	
	
	//鏍规嵁id鎵归噺鍒犻櫎澶氭潯鏁版嵁
	@Test
	public void delByIds() throws Exception{
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(7);
		ids.add(8);
		ids.add(9);
		System.out.println( ss.delByIds(ids));
	}
	
	
	//鎵归噺娣诲姞鏁版嵁
	@Test
	public void addBatch()throws Exception{
		List<User> userlist = new ArrayList<User>();
		for(int i=0; i<100; i++){
			User user = new User("璺汉"+ i , "luren"+i+"@A.com" , i+"" , new Date());
			userlist.add(user);
		}
		ss.addBatch(userlist);
	}
	
	
	//鑾峰彇鏁版嵁鎬绘暟
	@Test
	public void getCount()throws Exception{
		User user = new User();
		user.setEmail("@B.com");
		Map<String,Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("user", user);
		System.out.println("鏁版嵁鎬婚噺: "+ ss.getCount(parameterMap) );
	}
	
	//鏍规嵁澶氭潯浠舵煡璇�
	@Test
	public void findByParam()throws Exception{
		User user = new User();
		user.setUserName("璺汉9");
		user.setPwd("9");
		user.setEmail("luren9@A");
		User u = ss.findByParam(user);
		
		if( u != null)
			System.out.println( u.toString() );
		else
			System.out.println( "娌℃湁鎵惧埌瀵瑰簲鐨勬暟鎹�");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void findAllServiceByPage()throws Exception{
		
		System.out.println("ASAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		Page page = userService.findAll(null	, null);
		List<User> userlist =  page.getList();
		for (User u : userlist) {
			System.out.println( u.toString());
		}
	}
}
