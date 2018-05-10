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
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-form-label-sm">
        <c:forEach items="${sv}" var="s">
            <ul class="list-group float-sm-left text-center">
                <li class="list-group-item ">
                        ${s.maSv} - ${s.ho} ${s.ten}
                </li>
                <c:forEach items="${vb}" var="v">
                    <c:if test="${s.id==v.idSv}">
                        <li class="list-group-item ">
                                ${v.tenThuocTinh} : ${v.thuocTinh}
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </c:forEach>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>