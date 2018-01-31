<%@page import="com.tongji.tag.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.atguigu.com/mytag/core" prefix="atguigu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
 
 <br>
 <!-- 使用父标签实现等问题 -->
 <!-- 父标签打印name到控制台.  -->
    <atguigu:parentTag>
        <!-- 子标签以父标签的标签体存在,  子标签把父标签的name属性打印到 JSP 页面上.  -->
        <atguigu:sonTag/>
    </atguigu:parentTag>
   
   <br>
   <br>
  <!-- 自己实现的choose标签 --> 
  <!-- 注意>20}之间不能有空格。因为是Boolean类型的 -->
  <atguigu:choose>
    <atguigu:when test="${param.age > 20}">大学毕业</atguigu:when>
    <atguigu:when test="${param.age > 18}">高中毕业</atguigu:when>
    <atguigu:otherwise>没有毕业</atguigu:otherwise>
  </atguigu:choose>
    
  <br>
  <br>
  <!-- 使用自带的EL函数 -->
  ${fn:length(param.name)}
 
  <!-- 使用自己定义的EL函数 -->
  ${atguigu:concat(param.name1,param.name2)}
    
</body>
</html>