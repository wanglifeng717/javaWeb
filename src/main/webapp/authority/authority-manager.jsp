<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
    <br>
    <!-- 这里的action填写很重要，我们可以使用这种方式。 -->
    <form action="/javaWeb/authorityServlet?method=getAuthorities" method="post">
        name:<input type="text" name="username"/>
        <input type="submit" value="submit"/>
    </form>
    <br>
    <br>
    
    <c:if test="${requestScope.user !=null }">
        <br>
        ${requestScope.user.userName }的权限是：
        <br>
        
        <form action="/javaWeb/authorityServlet?method=updateAuthorities" method="post">
        
	        <input type="hidden" name="username" value="${requestScope.user.userName }"/>
	        <!-- 外层循环列出有哪些权限选项，选一个，然后内层循环遍历当前用户哪一个权限是和之比对，如果中了，就把这个权限标记为flag:true,然后显示为已经选定-->
	        <c:forEach items="${requestScope.authorities}" var="auth">
	           <c:set var="flag" value="false"></c:set>
	           <c:forEach items="${user.authorities }" var="ua">
	               <c:if test="${ua.url == auth.url}">
	                   <c:set var="flag" value="true"></c:set>
	               </c:if>	           
	           </c:forEach>
	           
	           <c:if test="${flag == true }">
	               <input type="checkbox" name="authority" value="${auth.url }" checked="checked"/>${auth.displayName }
	           </c:if>
	           <c:if test="${flag == false }">
                   <input type="checkbox" name="authority" value="${auth.url }" />${auth.displayName }
               </c:if>
                <br><br>    
	        </c:forEach>
        <input type="submit" value="update"/>
    </form>
    
    
    </c:if>
    

</center>

</body>
</html>