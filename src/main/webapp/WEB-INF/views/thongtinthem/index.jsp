<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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

<a href="/thongtinthem//add">Them Khoa</a> <br>

<c:forEach items="${thongtinthem}" var="t">
    <ul>
        <li>Giay to : ${t.tenThongTin} </li>
        <li> Thong tin :
            ${t.thongTin}
        <li>
        <li><a href="/thongtinthem/update/${t.thongtinsinhvien.maSv}-${t.id}">Update</a>
        <li>
        <li><a href="/thongtinthem/del/${t.thongtinsinhvien.maSv}-${t.id}">Delete</a>
        <li>

    </ul>
</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/khoa">Show All</a>
</c:if>

<br>


</body>
</html>