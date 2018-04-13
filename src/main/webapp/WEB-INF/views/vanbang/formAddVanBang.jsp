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
<f:form method="POST" modelAttribute="vanbang" name="vanbang">
    <f:hidden path="id"/>
   ma Van Bang <f:input path="maVanBang"/> <br>
    Ten Van Bang <f:input path="tenVanBang"/> <br>
    <input type="submit" value="Save"/>
</f:form>
</body>
</html>
