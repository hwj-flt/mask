<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/20
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>index</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div>
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="/user/userlist">用户管理</a></li>
            <li role="presentation"><a href="/order/orderlist">订单管理</a></li>
            <li role="presentation"><a href="/notice/index">公告管理</a></li>
            <li role="presentation"><a href="/logout">注销登录</a></li>
        </ul>
    </div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
