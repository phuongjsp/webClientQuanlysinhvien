<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/10/2018
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form add Khoa</title>
</head>
<body>
<f:form method="POST" modelAttribute="thongtinthem" name="thongtinthem">
    <f:hidden path="id"/>
    giay to <f:input path="tenThongTin"/> <br>
    thong tin <f:input path="thongTin"/> <br>
    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
