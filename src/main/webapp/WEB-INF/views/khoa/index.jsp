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

</head>
<body>
<jsp:include page="../HEADER.jsp"/>

<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/khoa/add">Thêm Khoa</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-form-label-sm">
        <c:if test="${khoa==null}">
            Thông tin không hợp lệ vui lòng kiểm tra lại
        </c:if>
        <c:if test="${khoa==null}">
            <c:forEach items="${khoa}" var="k">
    <ul class="list-group float-sm-left text-center">
        <li class="list-group-item ">
            Mã Khoa : ${k.maKhoa}
        </li>
        <li class="list-group-item  ">
            Tên Khoa : ${k.tenKhoa}
        </li>
        <li class="list-group-item ">
            Năm Học : ${k.namHoc}
        </li>
        <li class="list-group-item ">
            Ghi Chú : ${k.ghiChu}
        </li>
        <li class="list-group-item  "><a href="/khoa/update/${k.maKhoa}">Update</a>
        </li>
        <li class="list-group-item "><a href="/khoa/del/${k.maKhoa}">Delete</a>
        </li>
    </ul>
</c:forEach>
        </c:if>
    </div>
</div>


<br>

<jsp:include page="../FOOTER.jsp"/>
</body>
</html>