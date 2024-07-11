<%--
  Created by IntelliJ IDEA.
  User: dameng
  Date: 2024/7/9
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1 align="center">生活城市网登录</h1>
<form action="LoginServlet" method = "get" align="center">
    <p>昵称:<input type="text" name="name"></p>
    <p>密码:<input type="text" name="password"> </p>
    <p><input type="submit" value="登录" ></p>

</form>

</body>
</html>
