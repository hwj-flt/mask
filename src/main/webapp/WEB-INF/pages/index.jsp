<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/20
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h1>这里是后台首页</h1>
    ${sessionScope.get("username")}<br/>
    ${sessionScope.get("password")}
<a href="/logout">退出</a>
</body>
</html>
