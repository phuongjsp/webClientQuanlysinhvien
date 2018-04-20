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
            border-bottom: black solid;
        }

        li {
            margin-left: 20px;
        }
    </style>
</head>
<body>


<%--${khoa.tenKhoa}--%>

<a href="/SvCoVb/add/${maSv}">Them Khoa</a> <br>

<c:forEach items="${VB}" var="vb">
    <ul>
        <li> ${vb.tenVanBang} :</li>
        <c:forEach items="${svcovb}" var="tt">
            <c:if test="${vb.id==tt.loaiVb}">


                <c:if test="${tt.loaiVb==vb.id}">
                    <li>${tt.tenThuocTinh} : ${tt.thuocTinh}</li>
                    <li><a href="/SvCoVb/update/${maSv}-${tt.id}">Update</a></li>
                    <li><a href="/SvCoVb/del/${maSv}-${tt.id}">Delete</a></li>
                </c:if>


            </c:if>

        </c:forEach>
        <c:if test="${model!='only'}">
            <li><a href="/SvCoVb/only/maSv-${maSv}-maVb-${vb.maVanBang}">Show Only</a></li>
        </c:if>
    </ul>
</c:forEach>


<br>


</body>
</html>