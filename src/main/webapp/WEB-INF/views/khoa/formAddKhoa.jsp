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
<f:form method="POST" modelAttribute="khoa" name="khoa">
    <f:hidden path="id"/>
   ma khoa <f:input path="maKhoa"/> <br>
    Ten Khoa <f:input path="tenKhoa"/> <br>
    Nam Hoc <f:input path="namHoc"/> <br>
    Ghi Chu <f:input path="ghiChu"/> <br>
    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
