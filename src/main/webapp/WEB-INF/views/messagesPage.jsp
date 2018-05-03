<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/30/2018
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MESSAGES PAGE</title>
</head>
<body>
<jsp:include page="HEADER.jsp"/>
<div class="row text-center">
    <div class="col-lg-12">
        <p>${messages}</p>
    </div>
</div>
<jsp:include page="FOOTER.jsp"/>
</body>
</html>
