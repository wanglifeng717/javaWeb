<%@page import="com.tongji.tag.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.atguigu.com/mytag/core" prefix="atguigu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <atguigu:TestJspFragment>helloworld</atguigu:TestJspFragment>
 <br>
 <atguigu:PrintUpperTag time="7">wanglifeng</atguigu:PrintUpperTag>

 <br>
 <%
 List<Customer> customers = new ArrayList();
 customers.add(new Customer("wang",1));
 customers.add(new Customer("li",2));
 customers.add(new Customer("feng",3));
 customers.add(new Customer("zhang",4));
 
 request.setAttribute("customers", customers);
 %>
 <!-- 利用jstl原生自带的标签的处理方式 -->
 <c:forEach items="${requestScope.customers}" var="cust">
    ${cust.id } -- ${cust.name}
 </c:forEach>
 <br>
 <!-- 自己实现的foreach -->
 <atguigu:forEach items="${requestScope.customers}" var="cust">
     ${cust.id } -- ${cust.name}
 </atguigu:forEach>
</body>
</html>