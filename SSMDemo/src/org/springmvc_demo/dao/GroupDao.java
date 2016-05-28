package org.springmvc_demo.dao;

import java.io.Serializable;

public interface GroupDao<T,E> extends BaseDao<T, E>{

	public T findEntityMapByParam(Serializable id) throws Exception;
}
