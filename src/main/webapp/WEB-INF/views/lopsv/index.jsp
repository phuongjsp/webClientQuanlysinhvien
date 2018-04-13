<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<a href="/lopsv/add">Them Khoa</a> <br>

	<c:forEach items="${lopsv}" var="l">
<ul>
    <li>ma lop : ${l.maLop} </li>
        <li>	ten lop :	${l.tenLop}<li>
        <li> <a href="/lopsv/update/${l.maLop}">Update</a><li>
        <li>	<a href="/lopsv/del/${l.maLop}">Delete</a><li>
        <c:if test="${model == null }">
    <li>   <a href="/lopsv/maLop/${l.maLop}">Show Only</a><li>
    </c:if>
</ul>
	</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/lopsv">Show All</a>
</c:if>

<br>



</body>
</html>