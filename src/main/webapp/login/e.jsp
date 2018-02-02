<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 
		//检验用户是否登录. 若没有登录, 则直接重定向到 login.jsp
		Object user = session.getAttribute("user");
	
		if(user == null){
			response.sendRedirect("login.jsp");
		}
	--%>
	
	<h4>EEE PAGE</h4>
	<a href="list.jsp">Return...</a>
	
</body>
</html>