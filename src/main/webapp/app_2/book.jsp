<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4> Book Detail Page</h4>
    Book:<%= request.getParameter("book") %>
    <br><br>
    <a href="books.jsp">Return</a>
    
    <%
    String book = request.getParameter("book");
    //把书的信息以 Cookie 方式传回给浏览器，删除一个 Cookie
    //1. 确定要被删除的 Cookie：
    //前提: ATGUIGU_BOOK_ 开头的 Cookie 数量大于或等于 5，
    Cookie[] cookies = request.getCookies();
    
    List<Cookie> bookCookies = new ArrayList();
    
    Cookie tempCookie = null;
    
    if (cookies !=null && cookies.length >0){
    	for(Cookie c:cookies){
    		String cookieName = c.getName();
    		if(cookieName.startsWith("ATGUIGU_BOOK_")){
    			bookCookies.add(c);
    			
    			if(c.getValue().equals(book)){
    				tempCookie = c;
    			}
    		}
    	}
    }
  //①. 且若从 books.jsp 页面传入的 book 不在 ATGUIGU_BOOK_ 的 Cookie 中则删除较早的那个 Cookie
  //（ ATGUIGU_BOOK_  数组的第一个 Cbookie），
  if(bookCookies.size()>=5 && tempCookie==null){
	  tempCookie = bookCookies.get(0);
  }
  //②. 若在其中，则删除该 Cookie
  if(tempCookie!= null){
	  tempCookie.setMaxAge(0);
	  response.addCookie(tempCookie);
  }
  //2. 把从 books.jsp 传入的 book 作为一个 Cookie 返回 
  Cookie cookie = new Cookie("ATGUIGU_BOOK_" + book, book);
  response.addCookie(cookie);
    
    %>

</body>
</html>