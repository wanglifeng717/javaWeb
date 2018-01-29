<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入标签库(描述文件) -->    
<%@taglib uri="http://www.atguigu.com/mytag/core" prefix="atguigu" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 可以通过url的方式把值传进来http://localhost:8080/javaWeb/testTag.jsp?name=java -->
    <atguigu:hello value="${param.name}" count="5"/>
</body>
</html> 