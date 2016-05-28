<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'i18n.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
	<a href="i18nDemo?lang=zh">中文</a>&nbsp;&nbsp;<a href="i18nDemo?lang=en">英文</a><hr>
	<spring:message code="email"/><input type="text" name="email"><br>
	<spring:message code="pwd"/><input type="password" name="pwd"><br>
	<input type="button" name="login" value="<spring:message code="login"/>"/>
		
  </body>
</html>
