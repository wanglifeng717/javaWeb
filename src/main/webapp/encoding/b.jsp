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
		//编写一个 EncodingFilter
		//1. 读取 web.xml 文件中配置的当前 WEB 应用的初始化参数 encoding
		//2. 指定请求的字符编码为 1 读取到的编码
		//3. 调用 chain.doFilter() 方法 "放行" 请求
		request.setCharacterEncoding("UTF-8");
	--%>
	
	Hello: ${param.name }
	
</body>
</html>