<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 向客户端浏览器写入一个 Cookie: cookiePath, cookiePathValue -->
    <% 
        Cookie cookie = new Cookie("cookiePath", "CookiePathValue");
        //设置 Cookie 的作用范围：
        cookie.setPath(request.getContextPath());  
        response.addCookie(cookie);
        
        //Cookie 的 作用范围: 可以作用当前目录和当前目录的子目录. 但不能作用于当前目录的上一级目录. 
        //可以通过 setPath 方法来设置 Cookie 的作用范围, 其中 / 代表站点的根目录. 
    %>
    
    <a href="../cookie2.jsp">To Read Cookie</a>
    <br><br>
    
    <%= request.getContextPath() %>

</body>
</html>