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
<jsp:include page="../HEADER.jsp"/>
<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/sinhviencogiayto/add/maSv-${maSv}">Thêm Giấy tờ cho sinh viên này</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-form-label-sm ">
    <c:forEach items="${giayto}" var="g">
        <ul class="list-group float-sm-left text-center">
            <li class="list-group-item "> ${g.tenGiayTo} :
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
                <span style="color: blueviolet;"> Không</span>
            </c:if>
        </li>
        </ul>
    </c:forEach>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>