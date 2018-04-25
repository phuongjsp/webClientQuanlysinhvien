<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div class="container row">
    <div class="col-sm-12">
<c:if test="${listGiayToKhongCo.size()!=0}">
        <c:if test="${sinhviencogiayto==null}">
            Thông tin không hợp lệ vui lòng kiểm tra lại
        </c:if>
        <c:if test="${sinhviencogiayto!=null}">
        <f:form method="POST" modelAttribute="sinhviencogiayto" name="sinhviencogiayto">
        <ul class="list-group">
                <f:hidden path="id"/>
                <f:hidden path="idSv"/>
            <c:if test="${update==null}">
            <li class="list-group-item">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Mã Khoa</span>
                    </div>
                    <f:select path="idGiayTo"
                              type="text" class="form-control" aria-label="Default"
                              aria-describedby="inputGroup-sizing-default">
                        <c:forEach items="${listGiayToKhongCo}" var="g">
                            <fmt:formatNumber var="idgt"
                                              type="number" value="${g.id}"/>
                            <f:option value="${idgt}">${g.tenGiayTo}</f:option>
                        </c:forEach>
                    </f:select>
                </div>
            </li>
            </c:if>
            <c:if test="${update!=null}">
                <f:hidden path="idGiayTo"/>
                ${update}
            </c:if>
            <li class="list-group-item">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Thông tin</span>
                    </div>
                    <f:input path="thongtin"
                             type="text" class="form-control" aria-label="Default"
                             aria-describedby="inputGroup-sizing-default"/>
                </div>
            </li>
            <li class="list-group-item align-items-center">
                <input type="submit" class="list-group-item-action active text-center btn btn-success" value="Lưu"/>
            </li>
            </f:form>
            </c:if>
</c:if>
<c:if test="${listGiayToKhongCo.size()==0}">
            <h3 class="card-title">
                Sinh Viên Này Đẫ có đầy đủ các giấy tờ
            </h3>
            <a href="javascript:history.back()">Quay Lại</a>
</c:if>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
