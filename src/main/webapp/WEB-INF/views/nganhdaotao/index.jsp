<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Danh sach Khoa</title>
    <style>
        ul{
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border-bottom-color: red  ;
        }
       li {
            float: left;
           margin-left: 20px;
        }
    </style>
</head>
<body>




<%--${khoa.tenKhoa}--%>

<a href="/nganhdaotao/add">Them Khoa</a> <br>

	<c:forEach items="${nganhdaotao}" var="n">
<ul>
    <li>Ma Khoa	${n.maNganh} </li>
        <li>	Ten Ngnah	${n.tenNganh}<li>
        <li>khoa ${n.khoa} <li>
        <li>	Ghi Chu ${n.ghiChu}<li>
        <li> <a href="/nganhdaotao/update/${n.maNganh}">Update</a><li>
        <li>	<a href="/nganhdaotao/del/${n.maNganh}">Delete</a><li>
        <c:if test="${model == null }">
    <li>   <a href="/nganhdaotao/maNganh/${n.maNganh}">Show Only</a><li>
    </c:if>
</ul>
	</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/nganhdaotao">Show All</a>
</c:if>

<br>



</body>
</html>