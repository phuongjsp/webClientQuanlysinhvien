<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<f:form method="POST" modelAttribute="thongtingiadinh" name="thongtingiadinh">
    <f:hidden path="id"/>
    <f:hidden path="idSv"/>
    Quan He <f:input path="quanHe"/> <br>
    Ten <f:input path="ten"/> <br>
    sdt <f:input path="sdt"/> <br>
    nghe Nghiep <f:input path="ngheNghiep"/> <br>
    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
