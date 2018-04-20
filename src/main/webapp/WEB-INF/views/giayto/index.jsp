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

<a href="/giayto/add">Them Khoa</a> <br>

<c:forEach items="${giayto}" var="t">
    <ul>
        <li>Ma Giay To ${t.maGiayTo} </li>
        <li> Ten giay To
                ${t.tenGiayTo}
        <li>
        <li><a href="/giayto/update/${t.maGiayTo}">Update</a>
        <li>
        <li><a href="/giayto/del/${t.id}">Delete</a>
        <li>

    </ul>
</c:forEach>


<br>


</body>
</html>