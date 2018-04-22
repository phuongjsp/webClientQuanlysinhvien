<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello Page</title>
    <style>

    </style>
</head>
<body>


<%--${khoa.tenKhoa}--%>

<a href="/vanbang//add">Them Khoa</a> <br>

<c:forEach items="${vanbang}" var="v">
    <ul>
        <li>Ma Van Bang ${v.maVanBang} </li>
        <li> Ten Van Bang
                ${v.tenVanBang}
        <li>
        <li><a href="/vanbang/update/${v.maVanBang}">Update</a>
        <li>
        <li><a href="/vanbang/del/${v.maVanBang}">Delete</a>
        <li>
            <c:if test="${model == null }">
        <li><a href="/vanbang/maVanBang/${v.maVanBang}">Show Only</a>
        <li>
            </c:if>
    </ul>
</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/vanbang">Show All</a>
</c:if>

<br>


</body>
</html>