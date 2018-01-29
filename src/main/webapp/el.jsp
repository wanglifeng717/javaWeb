<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="el.jsp" method="post">
    <!-- 使用传统的方式回显 -->
        username:<input  type="text" name="username"
        value="<%=request.getParameter("username")==null?"":request.getParameter("username") %>"
        />
        <!-- 使用EL表达式进行回显 -->
        usernameOfEL:<input type="text" name="username" value="${param.username}"/>
        <input type="submit"value="submit"/>
    </form>
    
    username:<%= request.getParameter("username") %>
</body>
</html>