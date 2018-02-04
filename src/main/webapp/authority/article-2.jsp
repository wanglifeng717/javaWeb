<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	
	<%-- 
	
		//检查用户是否登录: session 中是否有 LoginSuccessSessionKey(SESSIONKEY 所对应的参数值) 的属性
		
		String sessionKey = application.getInitParameter("SESSIONKEY");
		Object obj = session.getAttribute(sessionKey);
		
		//1. 若存在, 表示已经登录, 继续浏览
		//2. 若不存在, 则表示用于未登录, 则重定向到 login.jsp 页面, 使其登录。 
		if(obj == null){
			response.sendRedirect(request.getContextPath() + "/app_3/login.jsp");
		}		
	
	--%>
	
	Article 222

</body>
</html>