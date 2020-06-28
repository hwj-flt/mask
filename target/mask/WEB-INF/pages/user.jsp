<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/20
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%-- 用于测试--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h1>这里是后台首页</h1>
    <form action="/updateUser" method="post">
    username:<input type="text" name="username" value="${username}" readonly><br/>
    password:<input type="text" name="password" value="${password}"><br/>
    sex:<input type="text" name="sex" value="${sex}"><br/>
    name:<input type="text" name="name" value="${name}"><br/>
    address:<input type="text" name="address" value="${address}"><br/>
    role:<input type="text" name="role" value="${role}"><br/>
    id:<input type="text" name="id" value="${id}"><br/>
    birthday:<input type="text" name="birthday" value="${birthday}"><br/>
    status:<input type="text" name="status" value="${status}"><br/>
    phone:<input type="text" name="phone" value="${phone}"><br/>
        <input type="submit" value="修改">
    </form>
<a href="/logout">退出</a>
</body>
</html>
