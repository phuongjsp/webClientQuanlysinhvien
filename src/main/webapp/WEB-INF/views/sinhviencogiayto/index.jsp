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

<a href="/sinhviencogiayto/add/maSv-${maSv}">Them </a> <br>

<ul>
    <c:forEach items="${giayto}" var="g">
        <li> ${g.tenGiayTo} :
            <c:set var="co" scope="session" value="${false}"/>
            <c:forEach items="${sinhviencogiayto}" var="sv">
                <c:if test="${sv.idGiayTo==g.id}">
                    <span style="color: red;"> ${sv.thongtin}</span>
                    <span style="color: chartreuse;"><a
                            href="/sinhviencogiayto/del/maSv-${maSv}-${sv.id}">Del</a></span>
                    <span style="color: chartreuse;"><a
                            href="/sinhviencogiayto/update/maSv-${maSv}-${sv.id}">Upd</a></span>
                    <c:set var="co" scope="session" value="${true}"/>
                </c:if>

            </c:forEach>
            <c:if test="${!co}">
                <span style="color: blueviolet;"> Khong</span>
            </c:if>
        </li>
    </c:forEach>
</ul>


<br>


</body>
</html>