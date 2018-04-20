<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/10/2018
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form add Thong tin gia dinh</title>
</head>
<body>
<f:form method="POST" modelAttribute="svcovb" name="svcovb">
    <f:hidden path="id"/>
    <f:hidden path="idSv"/>
    Loai VB <f:select path="loaiVb">
    <c:forEach items="${VB}" var="vb">
        <fmt:formatNumber var="idvb"
                          type="number" value="${vb.id}"/>
        <f:option value="${idvb}">${vb.tenVanBang}</f:option>
    </c:forEach>
</f:select> <br>
    Ten thuoc tinh<f:input path="tenThuocTinh"/> <br>
    Gia tri <f:input path="thuocTinh"/> <br>

    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
