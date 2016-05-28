package org.springmvc_demo.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springmvc_demo.dao.BaseDao;
import org.springmvc_demo.entity.User;
import org.springmvc_demo.service.BaseService;
import org.springmvc_demo.util.Page;

@Service("userService")
public class UserServiceImpl implements BaseService<User>{

	private BaseDao<User,Integer> userDao;
	
	@Resource(name="userDao")
	public void setUserDao(BaseDao<User,Integer> userDao) {
		this.userDao = userDao;
	}


	public boolean add(User entity) throws Exception{
		return userDao.add(entity);
	}


	public Page findAll(User entity ,Page page)throws Exception{

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		if( entity != null) 
			parameterMap.put("user", entity);

		int count = userDao.getCount(parameterMap);
		page = new Page(count , page == null ? 1 : page.getPageNumber() );
		
		parameterMap.put("page", page);
		page.setList( userDao.findAllByPage(parameterMap) );
		return page; 
	}


	public User findById(Serializable id) throws Exception{
		return userDao.findById(id);
	}

	
	
}
