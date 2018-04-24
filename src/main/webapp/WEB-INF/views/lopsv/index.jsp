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
    <title>Danh Sách Lớp</title>

</head>
<body>
<jsp:include page="../HEADER.jsp"/>
<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/lopsv/add">Thêm Lớp</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-form-label-sm ">
	<c:forEach items="${lopsv}" var="l">
        <ul class="list-group float-sm-left text-center ">
            <li class="list-group-item ">
                Mã Lớp : ${l.maLop}
            </li>
            <li class="list-group-item ">
                Tên Lớp : ${l.tenLop}
            </li>
            <li class="list-group-item">
                <a href="/lopsv/update/${l.maLop}">Update</a>
            </li>
            <li class="list-group-item ">
                <a href="/lopsv/del/${l.maLop}">Delete</a>
            </li>
        </ul>
	</c:forEach>
    </div>
</div>

<jsp:include page="../FOOTER.jsp"/>
</body>
</html>