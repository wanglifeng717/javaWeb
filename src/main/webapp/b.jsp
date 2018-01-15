<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4>BBB page</h4>
    <%
    //1.请求转发的代码：
    //这个代码会转发到C.jsp的页面，显示CCC page.但是URL还显示的是http://localhost:8080/javaWeb/b.jsp
    //request.getRequestDispatcher("/c.jsp").forward(request, response);
    
    //2.请求的重定向
    //这个也显示的CCC page。但是URL显示的是http://localhost:8080/javaWeb/c.jsp
    response.sendRedirect("c.jsp");
    %>
</body>
</html>