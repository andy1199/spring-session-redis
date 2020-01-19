<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sessionDemo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
<%--	<%--%>
<%--		request.getSession().setAttribute("user", new User("zhangsan", "123456"));--%>
<%--	%>--%>
<%--	jsessionid=${pageContext.session.id}--%>

<h2>Hello World</h2>
	<br />
	${user.username}
	<br />
	<%=request.getRealPath("/")%>
</body>
</html>