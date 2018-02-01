<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    
    <c:if test="${requestScope.message !=null }">
        <br>
            <font color="red">${requestScope.message }</font>
        <br>
    </c:if>
    <form action="addCustomer.do" method="post">
    
        
        <table>
            <tr>
                <td>CustomerName:</td>
                <td><input type="text" name="name" value="${param.name }"/>
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" value="${param.address }"/></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone" value="${param.phone }"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form>
</body>
</html>