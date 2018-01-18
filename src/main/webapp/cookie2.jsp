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
  String cookieValue =null;
  Cookie[] cookies = request.getCookies();
  if(cookies !=null && cookies.length>0){
	  for(Cookie c:cookies){
		  if("cookiePath".equals(c.getName())){
			   cookieValue=c.getValue();
		  }
	  }
  }
  
  if(cookieValue != null){
	  out.print(cookieValue);
  } else{
	  out.print("没有指定的cookie");
  }


%>
</body>
</html>