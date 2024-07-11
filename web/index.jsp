<%@ page import="java.util.List" %>
<%@ page import="com.yhq.vo.User" %>
<%@ page import="com.yhq.servlet.UserServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: dameng
  Date: 2024/7/8
  Time: 下午7:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>swufe is best</h1>
  <%
  String s ="";
  List<User> list =(List<User>) request.getAttribute("userinfo");
  %>
  <h1>欢迎<%=session.getAttribute("Username")%>登录</h1>
  <table align="center" border="1px" width="200px">
  <tr><th>ID</th><TH>NAME</TH><TH>PWD</TH><TH>AGE</TH><TH>SEX</TH><TH>操作</TH>
    <%for (User u:list){%>
      <tr>
    <th><%=u.getId()%></th>
    <th><%=u.getName()%></th>
    <th><%=u.getPassword()%></th>
    <th><%=u.getAge()%></th>
    <th><%=u.getSex()%></th>
    <th><a href="UserDeleteServlet?id=<%=u.getId()%>">删除</a>
      <a href="UserSelectByIdServlet?id=<%=u.getId()%>">修改</a>
    </th>

      </tr>
    <%}%>
  </tr>
    <tr><th><a href="userAdd.jsp">增加</a> </th></tr>
  </table>
  </body>
</html>
