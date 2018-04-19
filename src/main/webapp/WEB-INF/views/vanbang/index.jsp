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

<a href="/vanbang//add">Them Khoa</a> <br>

	<c:forEach items="${vanbang}" var="v">
<ul>
    <li>Ma Van Bang	${v.maVanBang} </li>
        <li>	Ten Van Bang	${v.tenVanBang}<li>
        <li> <a href="/vanbang/update/${v.maVanBang}">Update</a><li>
        <li>	<a href="/vanbang/del/${v.maVanBang}">Delete</a><li>
        <c:if test="${model == null }">
    <li>   <a href="/vanbang/maVanBang/${v.maVanBang}">Show Only</a><li>
    </c:if>
</ul>
	</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/vanbang">Show All</a>
</c:if>

<br>



</body>
</html>