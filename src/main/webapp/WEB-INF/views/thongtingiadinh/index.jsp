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
    <a class="mr-sm-5" href="/thongtingiadinh/add/${maSv}">Thêm Thông Tin Gia Đình Cho Sinh Viên Này</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<%--${khoa.tenKhoa}--%>
<div class="row">
    <div class="col-form-label-sm">
<c:forEach items="${thongtingiadinh}" var="t">
    <ul class="list-group float-sm-left text-center">
        <li class="list-group-item ">${t.quanHe} </li>
        <li class="list-group-item "> Thông tin :</li>
        <li class="list-group-item ">Tên : ${t.ten}</li>
        <li class="list-group-item ">Nghề Nghiệp : ${t.ngheNghiep}</li>
        <li class="list-group-item ">SDT : ${t.sdt}</li>
        <li class="list-group-item "><a href="/thongtingiadinh/update/${maSv}-${t.id}">Update</a></li>
        <li class="list-group-item "><a href="/thongtingiadinh/del/${maSv}-${t.id}">Delete</a>
        </li>
    </ul>
</c:forEach>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>