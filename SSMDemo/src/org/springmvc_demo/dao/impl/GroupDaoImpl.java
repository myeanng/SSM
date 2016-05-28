package org.springmvc_demo.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springmvc_demo.dao.GroupDao;
import org.springmvc_demo.entity.Group;
import org.springmvc_demo.util.SqlSessionDaoSupportTool;

@SuppressWarnings("unchecked")
@Repository("groupDao")
public class GroupDaoImpl extends SqlSessionDaoSupportTool implements GroupDao<Group, Integer>{

	public boolean add(Group entity) throws Exception{
		return getSqlSession().getMapper(GroupDao.class).add(entity);
	}

	public boolean addBatch(List<Group> entityList) throws Exception{
		return getSqlSession().getMapper(GroupDao.class).addBatch(entityList);
	}

	public boolean delByIds(List<Integer> ids) throws Exception{
		return false;
	}

	public boolean delete(Serializable id) throws Exception{
		return false;
	}

	public Group findById(Serializable id) throws Exception{
		return (Group) getSqlSession().getMapper(GroupDao.class).findById(id);
	}

	public Group findByParam(Group entity) throws Exception{
		return null;
	}

	public int getCount(Map<String,Object> parameterMap) throws Exception{
		return 0;
	}

	public boolean update(Group entity) throws Exception{
		return false;
	}

	public Group findEntityMapByParam(Serializable id) throws Exception {
		return (Group) getSqlSession().getMapper(GroupDao.class).findEntityMapByParam(id);
	}

	public List<Group> findEntityListByParam(Serializable id) throws Exception {
		return getSqlSession().getMapper(GroupDao.class).findEntityListByParam(id);
	}

	public List<Group> findAllByPage(Map<String, Object> parameterMap)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
