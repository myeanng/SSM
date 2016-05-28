package org.springmvc_demo.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springmvc_demo.dao.UserDao;
import org.springmvc_demo.entity.User;
import org.springmvc_demo.util.SqlSessionDaoSupportTool;


@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupportTool implements UserDao<User , Integer>{

	public boolean add(User entity) throws Exception{
		
		return getSqlSession().getMapper(UserDao.class).add(entity);
	}

	public User findById(Serializable id) throws Exception{

		return (User) getSqlSession().getMapper(UserDao.class).findById(id);
	}
	
	public User findByParam(User entity) throws Exception{
		//return (User) getSqlSession().getMapper(UserDao.class).findByParam(entity);
		return (User) getSqlSession().selectOne("org.springmvc_demo.dao.UserDao.findByParam" ,entity);
	}

	public boolean update(User entity)throws Exception {
		return getSqlSession().getMapper(UserDao.class).update(entity);
	}


	public boolean delByIds(List<Integer> ids) throws Exception{
		return getSqlSession().getMapper(UserDao.class).delByIds(ids);
	}


	public boolean delete(Serializable id) throws Exception{
		return getSqlSession().getMapper(UserDao.class).delete(id);
	}


	public boolean addBatch(List<User> entityList) throws Exception{
		return getSqlSession().getMapper(UserDao.class).addBatch(entityList);
	}


	public int getCount(Map<String,Object> parameterMap) throws Exception{
		return getSqlSession().getMapper(UserDao.class).getCount(parameterMap);
	}

	public List<User> findEntityListByParam(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAllByPage(Map<String, Object> parameterMap)
			throws Exception {
		return getSqlSession().getMapper(UserDao.class).findAllByPage(parameterMap);
	}

}
