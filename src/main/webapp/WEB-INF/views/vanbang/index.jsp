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
</head>
<body>
<jsp:include page="../HEADER.jsp"/>
<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/vanbang//add">Thêm Văn Bằng</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-form-label-sm">
        <c:forEach items="${vanbang}" var="v">
            <ul class="list-group float-sm-left text-center">
                <li class="list-group-item ">
                    Mã Văn Bằng : ${v.maVanBang}
                </li>
                <li class="list-group-item ">
                    Tên Văn Bằng : ${v.tenVanBang}
                </li>
                <li class="list-group-item">
                    <a href="/vanbang/update/${v.maVanBang}">Update</a>
                </li>
                <li class="list-group-item ">
                    <a href="/vanbang/del/${v.maVanBang}">Delete</a>
                </li>
            </ul>
        </c:forEach>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>