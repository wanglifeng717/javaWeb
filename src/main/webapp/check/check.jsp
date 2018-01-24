<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 显示我们验证码是否正确的提示信息 -->
    <font color="red">
        <%= session.getAttribute("message") == null ? "" : session.getAttribute("message")%>
       
    </font>
    
    
    <form action="<%= request.getContextPath() %>/checkCodeServlet" method="post">
        <!-- 带回显的方式 -->                
                         用户名: <input type="text" name="name" value="<%= session.getAttribute("name")==null?"":session.getAttribute("name")%>"/>
                         密码: <input type="text" name="password" value="<%= session.getAttribute("password")==null?"":session.getAttribute("password")%>"/>                        
        checkCode: <input type="text" name="CHECK_CODE_PARAM_NAME"/> 
        <img alt="加载失败" src="<%= request.getContextPath() %>/validateColorServlet">      
        <input type="submit" value="换一张"/>
        <input type="submit" value="登录"/>
        
    </form>
    
    
        
   
</body>
</html>