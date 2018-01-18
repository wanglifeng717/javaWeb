<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
  //若可以获取到请求参数 name, 则打印出欢迎信息。把登录信息存储到 Cookie 中，并设置 Cookie 的最大时效为 30S
  String name = request.getParameter("name");
    if(name!=null && ! name.trim().equals("")){
    	Cookie cookie = new Cookie("name",name);
    	cookie.setMaxAge(30);
    	response.addCookie(cookie);
    } else{
    //从 Cookie 中读取用户信息，若存在则打印欢迎信息
    Cookie[] cookies = request.getCookies();
    if(cookies!=null && cookies.length >0){
    	for(Cookie cookie:cookies){
    		String cookieName = cookie.getName();
    		if("name".equals(cookieName)){
    			String val = cookie.getValue();
    			name = val;
    		}
    	}
    }
    }
    
    if(name !=null && ! name.trim().equals("")){
    	out.print("hello"+name);
    }else{
    	//若既没有请求参数，也没有 Cookie，则重定向到 login.jsp
    	response.sendRedirect("login.jsp");
    }
    
    %>
</body>
</html>