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

<a href="/thongtingiadinh/add/${maSv}">Them Khoa</a> <br>

<c:forEach items="${thongtingiadinh}" var="t">
    <ul>
        <li>${t.quanHe} </li>
        <li> Thong tin :</li>

        <li>Ten : ${t.ten}</li>
        <li>Nghe Nghiep : ${t.ngheNghiep}</li>
        <li>SDT : ${t.sdt}</li>
        <li><a href="/thongtingiadinh/update/${maSv}-${t.id}">Update</a></li>
        <li><a href="/thongtingiadinh/del/${maSv}-${t.id}">Delete</a>
        </li>

    </ul>
</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/th">Show All</a>
</c:if>

<br>


</body>
</html>