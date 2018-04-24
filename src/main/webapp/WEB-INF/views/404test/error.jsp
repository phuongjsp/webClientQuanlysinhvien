<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/24/2018
  Time: 6:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <p>Trang Không tồn ti hoặc đã bị xóa vui lòng liên hệ với admin để giải quyết vấn đề này</p>
        Lỗi : <p>
        <p>Message: <b>${exception.message}</b></p>
        <p>Exception: <b>${exception['class'].name}</b></p></p>
    </div>
</div>
<jsp:include page="FOOTER.jsp"/>
</body>
</html>
