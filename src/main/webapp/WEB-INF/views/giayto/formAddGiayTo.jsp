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
    <title>Form add Giay to</title>
</head>
<body>
<f:form method="POST" modelAttribute="giayto" name="giayto">
    <f:hidden path="id"/>
    ma giay to <f:input path="maGiayTo"/> <br>
    Ten giay to<f:input path="tenGiayTo"/> <br>
    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
