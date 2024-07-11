<%--
  Created by IntelliJ IDEA.
  User: dameng
  Date: 2024/7/10
  Time: 下午2:07
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
    生活网增加页面
</h1>
<form align="center" action="UserAddServlet" method="get">
    <p>工号：<input type="text" name="id"></p>
    <p>姓名：<input type="text" name="username"></p>
    <p>密码：<input type="password" name="pwd"></p>
    <p>年龄：<input type="text" name="age"></p>
    <p>性别：<input type="text" name="sex"></p>
    <p>增加：<input type="submit" name="增加"></p>
</form>
</body>
</html>
