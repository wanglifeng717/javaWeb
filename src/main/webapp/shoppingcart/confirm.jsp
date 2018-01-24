<%@page import="com.tongji.javaWeb.Customer"%>
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
   
        Customer customer = (Customer)session.getAttribute("customer");
        String [] books = (String[])session.getAttribute("books");
       
    %>
    
    <table>
        <tr>
            <td>顾客姓名:</td>
            <td><%= customer.getName() %></td>
        </tr>
        <tr>
            <td>地址:</td>
            <td><%= customer.getAddress() %></td>
        </tr>
        <tr>
            <td>卡号:</td>
            <td><%= customer.getCard() %></td>
        </tr>
        <tr>
            <td>卡的类型:</td>
            <td><%= customer.getCardType() %></td>
        </tr>
        <tr>
            <td>Books:</td>
            <td>
                <% 
                    for(String book: books){
                        out.print(book);
                        out.print("<br>");
                    }
                %>
            </td>
        </tr>
    </table>
</body>
</html>