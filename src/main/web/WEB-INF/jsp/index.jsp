<%--
  Created by IntelliJ IDEA.
  User: 周超
  Date: 2020/4/9
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <title>index</title>
</head>
<body>
<div class="workingroom">
    <div class="loginDiv">
        <c:if test="${empty subject.principal}">
            <a href="index">登陆</a><br>
        </c:if>
        <c:if test="${!empty subject.principal}">
            <span class="desc">你好,${subject.principal},</span>
            <a href="doLogout">退出</a>
        </c:if>

        <a href="listProduct">查看产品</a><span class="desc">(登录后才可以查看) </span><br>
        <a href="deleteProduct">删除产品</a><span  class="desc">(要有产品管理员角色, zhang3没有，li4 有) </span><br>
        <a href="deleteOrder">删除订单</a><span class="desc">(要有删除订单权限, zhang3有，li4没有) </span><br>
    </div>
</div>
</body>
</html>
