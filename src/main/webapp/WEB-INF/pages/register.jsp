<%--
  Created by IntelliJ IDEA.
  User: TR
  Date: 2020/6/24
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>S
    <title>Title</title>
</head>
<body>
<form action="/register" method="post">
    真实姓名:<input type="text" name="name" value="name"> <br>
    身份证号码:<input type="text" name="id" value="id"> <br>
    用户名:<input type="text" name="username" value="username"> <br>
    性别:<input type="radio" name="sex" value="男">
    <input type="radio" name="sex" value="女"> <br>
    密码:<input type="password" name="password" value="password"> <br>
    居住地:<input type="text" name="address" value="address"> <br>
    电话号码:<input type="text" name="phone" value="phone"> <br>
    <button type="submit">提交</button>
</form>
</body>
</html>
