package org.springmvc_demo.service;

import java.io.Serializable;

import org.springmvc_demo.util.Page;

public interface BaseService<T> {

	/**
	 * 添加单条数据w
	 * @param entity
	 * @return 成功|失败
	 */
	boolean add(T entity)throws Exception;

	/**
	 * 查询多条数据
	 * @return 分页对象，里面包含返回的数据列表和分页所需数据
	 */
	public Page findAll(T entity ,Page pager)throws Exception;
	
	
	/**
	 * 根据ID查询单挑数据
	 * @param id
	 * @return
	 */
	public T findById(Serializable id)throws Exception;
	
}
