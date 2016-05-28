package org.springmvc_demo.interceptor;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springmvc_demo.util.Page;


/**
 * 持久层分页拦截器(MyBatis)
 * @author Merlin.Ma
 *
 */

@Intercepts(@Signature(type=StatementHandler.class,method="prepare",args={Connection.class}))
public class PageInterceptor implements Interceptor{
	
	@SuppressWarnings("unchecked")
	public Object intercept(Invocation invocation) throws Throwable {
		
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		
		MetaObject metaObject = MetaObject.forObject(
				statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY , SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		
		/*
		 * 	第一步，拦截需要增加分页的查询
		 *	获取配置文件中sql语句的ID,判断是否需要增加分页功能 
		 */
		if(  mappedStatement.getId().matches(".*Page$") ){
			BoundSql boundSql = statementHandler.getBoundSql();
			
			//获取sql对应的值的map集合
			Map<String, Object> parameterMap = (Map<String, Object>) boundSql.getParameterObject();
			//抽出分页对象
			Page page = (Page) parameterMap.get("page");
			
			/*
			 * 第二步，偷梁换柱，在原来的SQL上面增加分页功能。
			 * 获取原始的SQL语句,然后拼接分页语句
			 */
			StringBuffer pageSql = new StringBuffer(boundSql.getSql());
			pageSql.append(" limit ").append(page.getPageIndex()).append(" , ").append(page.getLimit());
			
			/*
			 * 第三步，将拼接好的分页sql再放回去
			 */
			metaObject.setValue("delegate.boundSql.sql", pageSql.toString());
		}
		
		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		if( target instanceof StatementHandler)
			return Plugin.wrap(target, this);
		else
			return target;
	}

	public void setProperties(Properties arg0) {
		
	}

}
