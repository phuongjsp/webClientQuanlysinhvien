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

<%--${khoa.tenKhoa}--%>
<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/thongtinthem/add/${maSv}">Thêm Thông Tin cho sinh viên này</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>

<div class="row">
    <div class="col-form-label-sm">
        <c:if test="${thongtinthem==null}">
            Thông tin không tồn tại
        </c:if>
        <c:if test="${thongtinthem!=null}">
<c:forEach items="${thongtinthem}" var="t">
    <ul class="list-group float-sm-left text-center">
        <li class="list-group-item "> ${t.tenThongTin} </li>
        <li class="list-group-item ">
                ${t.thongTin}
        </li>
        <li class="list-group-item "><a href="/thongtinthem/update/${t.thongtinsinhvien.maSv}-${t.id}">Update</a>
        </li>
        <li class="list-group-item "><a href="/thongtinthem/del/${t.thongtinsinhvien.maSv}-${t.id}">Delete</a>
        </li>
    </ul>
</c:forEach>
        </c:if>
    </div>
</div>

<jsp:include page="../FOOTER.jsp"/>
</body>
</html>