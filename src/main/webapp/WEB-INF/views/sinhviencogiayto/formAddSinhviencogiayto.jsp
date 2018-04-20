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
<c:if test="${listGiayToKhongCo.size()!=0}">
    <f:form method="POST" modelAttribute="sinhviencogiayto" name="sinhviencogiayto">
        <f:hidden path="id"/>
        <f:hidden path="idSv"/>
        <c:if test="${update==null}">
            <f:select path="idGiayTo">
                <c:forEach items="${listGiayToKhongCo}" var="g">
                    <fmt:formatNumber var="idgt"
                                      type="number" value="${g.id}"/>
                    <f:option value="${idgt}">${g.tenGiayTo}</f:option>
                </c:forEach>
            </f:select>
        </c:if>
        <c:if test="${update!=null}">
            <f:hidden path="idGiayTo"/>
            ${update}
        </c:if>
        Thong tin <f:input path="thongtin"/> <br>
        <input type="submit" value="Save"/>
    </f:form>
</c:if>
<c:if test="${listGiayToKhongCo.size()==0}">
    Sinh vien da day du giay to
</c:if>
</body>
</html>
