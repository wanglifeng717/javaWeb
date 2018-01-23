<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%=  session.getId()%>
    <%
    //可以看到，jsessionid不是我们创建的，而是从session对象里面获取的。
    Cookie cookie = new Cookie("JSESSIONID",session.getId());
    //把这个cookie变成持久化cookie
    cookie.setMaxAge(20);
    response.addCookie(cookie);
    %>
</body>
</html>