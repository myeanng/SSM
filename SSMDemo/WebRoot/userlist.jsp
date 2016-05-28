<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.iteye.com/tags/pager" prefix="w"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
	<table>
	<tr>
		<td>ID</td><td>用户名</td><td>电子邮箱</td>
	</tr>
	<c:forEach items="${userPage.list}" var="user">
		<tr>
			<td>${user.userId}</td><td>${user.userName}</td><td>${user.email}</td>
		</tr>
	</c:forEach>
	</table>
	<w:pager pageSize="${userPage.limit}" pageNumber="${userPage.pageNumber}" url="findAll" recordCount="${userPage.total}"/>
  </body>
</html>
