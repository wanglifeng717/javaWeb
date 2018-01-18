<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% 
        //在 JavaWEB 规范中使用 Cookie 类代表 cookie
        
        
        
        //1. 获取 Cookie
        Cookie [] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for(Cookie cookie: cookies){
                //2. 获取 Cookie 的 name 和 value
                out.print(cookie.getName() + ": " + cookie.getValue());
                out.print("<br>"); 
            }
        }else{
            out.print("没有一个 Cookie, 正在创建并返回");
            //1. 创建一个 Cookie 对象
            Cookie cookie = new Cookie("name", "atguigu");
            //setMaxAge: 设置 Cookie 的最大时效, 以秒为单位, 若为 0 , 表示立即删除该 Cookie
            //若为负数, 表示不存储该 Cookie, 若为正数, 表示该 Cookie 的存储时间.即使你关闭浏览器再开，同样有效，通过时间设定的。 
            cookie.setMaxAge(30);
            
            //2. 调用 response 的一个方法把 Cookie 传给客户端. 
            response.addCookie(cookie);
        }
    %>
</body>
</html>