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
<f:form method="POST" modelAttribute="diachi" name="diachi">
    <f:hidden path="id"/>
   Tinh <f:input path="tinh"/> <br>
   Quan Huyen <f:input path="quanHuyen"/> <br>
   Xa Phuong <f:input path="xaPhuong"/> <br>
    Thon Xom <f:input path="thonXom"/> <br>
    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
