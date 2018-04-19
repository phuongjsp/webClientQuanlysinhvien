<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
    <title>Form add Lop</title>
</head>
<body>
<f:form method="POST" modelAttribute="lopsv" name="lopsv">
    <f:hidden path="id"/>
    ma Lop <f:input path="maLop"/> <br>
    ten Lop <f:input path="tenLop"/> <br>
    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
