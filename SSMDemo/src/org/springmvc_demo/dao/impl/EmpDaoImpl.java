package org.springmvc_demo.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springmvc_demo.dao.EmployeDao;
import org.springmvc_demo.entity.Employe;
import org.springmvc_demo.util.SqlSessionDaoSupportTool;

@SuppressWarnings("unchecked")
@Repository("empDao")
public class EmpDaoImpl extends SqlSessionDaoSupportTool implements EmployeDao<Employe, Integer>{

	public Employe findEntityMapByParam(Serializable id) throws Exception {
		return null;
	}

	public boolean add(Employe entity) throws Exception{
		return getSqlSession().getMapper(EmployeDao.class).add(entity);
	}

	public boolean addBatch(List<Employe> entityList) throws Exception{
		return false;
	}

	public boolean delByIds(List<Integer> ids) throws Exception{
		return false;
	}

	public boolean delete(Serializable id) throws Exception{
		return false;
	}

	public Employe findById(Serializable id) throws Exception{
		return (Employe) getSqlSession().getMapper(EmployeDao.class).findById(1);
	}

	public Employe findByParam(Employe entity) throws Exception{
		return (Employe) getSqlSession().getMapper(EmployeDao.class).findByParam(entity);
	}

	public int getCount(Map<String,Object> parameterMap) throws Exception{
		return 0;
	}

	public boolean update(Employe entity) throws Exception{
		return false;
	}

	public List<Employe> findEntityListByParam(Serializable id)
			throws Exception {
		return getSqlSession().getMapper(EmployeDao.class).findEntityListByParam(id);
	}

	public List<Employe> findAllByPage(Map<String, Object> parameterMap)
			throws Exception {
		return null;
	}

}
