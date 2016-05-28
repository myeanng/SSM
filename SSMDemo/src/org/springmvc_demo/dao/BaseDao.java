package org.springmvc_demo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T , E> {

	/**
	 * 添加一条新数据
	 * @param entity
	 * @return 成功 | 失败
	 */
	public boolean add(T entity) throws Exception;
	
	
	/**
	 * 批量增加数据
	 * @param entityList
	 * @return 成功|失败
	 */
	public boolean addBatch(List<T> entityList)throws Exception;
	
	
	/**
	 * 更新单条数据
	 * @param entity
	 * @return 成功|失败
	 */
	public boolean update(T entity)throws Exception;
	
	
	/**
	 * 根据ID删除单条数据
	 * @param id
	 * @return 成功|失败
	 */
	public boolean delete(Serializable id)throws Exception;
	
	/**
	 * 根据多条ID做批量删除数据
	 * @param ids
	 * @return 成功|失败
	 */
	public boolean delByIds(List<E> ids)throws Exception;

	/**
	 * 根据ID查询单条数据
	 * @param id
	 * @return 查询出来的对象|null
	 */
	public T findById(Serializable id)throws Exception;
	
	/**
	 * 根据多条件查询单条数据
	 * @param entity
	 * @return 查询出来的对象|null
	 */
	public T findByParam(T entity)throws Exception;
	
	/**
	 * 查询所有的数据
	 * @return 数据列表
	 */
	public List<T> findAllByPage(Map<String, Object> parameterMap )throws Exception;
	
	/**
	 * 根据ID返回对应的数据列表
	 * @param id
	 * @return 数据列表
	 * @throws Exception
	 */
	public List<T> findEntityListByParam(Serializable id) throws Exception;
	
	/**
	 * 获取某张表的数据量总数
	 * @return
	 */
	public int getCount(Map<String,Object> parameterMap)throws Exception;
}
