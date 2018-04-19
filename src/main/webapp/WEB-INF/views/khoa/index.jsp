<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Danh sach Khoa</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border-bottom-color: red;
        }

        li {
            float: left;
            margin-left: 20px;
        }
    </style>
</head>
<body>


<%--${khoa.tenKhoa}--%>

<a href="/khoa/add">Them Khoa</a> <br>

<c:forEach items="${khoa}" var="k">
    <ul>
        <li>Ma Khoa ${k.maKhoa} </li>
        <li> Ten Khoa
                ${k.tenKhoa}
        <li>
        <li> Nam Hoc
                ${k.namHoc}
        <li>
        <li> Ghi CHu
                ${k.ghiChu}
        <li>
        <li><a href="/khoa/update/${k.maKhoa}">Update</a>
        <li>
        <li><a href="/khoa/del/${k.maKhoa}">Delete</a>
        <li>
            <c:if test="${model == null }">
        <li><a href="/khoa/maKhoa/${k.maKhoa}">Show Only</a>
        <li>
            </c:if>
    </ul>
</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/khoa">Show All</a>
</c:if>

<br>


</body>
</html>