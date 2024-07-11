<%@ page import="com.yhq.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: dameng
  Date: 2024/7/11
  Time: 下午2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>都市生活网</title>
</head>
<body bgcolor="aqua">
<h1 align="center">
    swufe is bset
</h1>
<h1 align="center">
    生活网详情页面
</h1>
<form align="center"  method="get">
    <%
        User u = (User)request.getAttribute("userinfo");
    %>
    <p>工号：<input type="text" value="<%=u.getId()%>" name="id" readonly="readonly"></p>
    <p>姓名：<input type="text" name="name" value="<%=u.getName()%>"></p>
    <p>密码：<input type="text" name="pwd" value="<%=u.getPassword()%>"></p>
    <p>年龄：<input type="text" name="age" value="<%=u.getAge()%>"></p>
    <p>性别：<input type="text" name="sex" value="<%=u.getSex()%>"></p>
    <p><a>信息管理</a></p>
    <a href="login.jsp">主页面</a>
</form>
</body>
</html>
