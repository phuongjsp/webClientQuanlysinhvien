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
    <title>Form add Giay to</title>
</head>
<body>
<jsp:include page="../HEADER.jsp"/>
<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="container row">
    <div class="col-sm-12">
        <c:if test="${giayto==null}">
            Mã giấy tờ không tồn tại vui lòng kiểm tra lại
        </c:if>
        <c:if test="${giayto!=null}">
            <f:form method="POST" modelAttribute="giayto" name="giayto">
                <ul class="list-group">
                    <f:hidden path="id"/>
                    <li class="list-group-item">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Mã Giấy tờ</span>
                            </div>
                            <f:input path="maGiayTo"
                                     type="text" class="form-control" aria-label="Default"
                                     aria-describedby="inputGroup-sizing-default"/>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Tên Giấy tờ</span>
                            </div>
                            <f:input path="tenGiayTo"
                                     type="text" class="form-control" aria-label="Default"
                                     aria-describedby="inputGroup-sizing-default"/>
                        </div>
                    </li>
                    <li class="list-group-item align-items-center">
                        <input type="submit" class="list-group-item-action active text-center btn btn-success"
                               value="Lưu"/>
                    </li>
                </ul>
            </f:form>
        </c:if>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
