<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Danh sach Khoa</title>
    <style>
        ul{
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border-bottom-color: red  ;
        }
       li {
            float: left;
           margin-left: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="../HEADER.jsp"/>



<%--${khoa.tenKhoa}--%>
 <ul>
     <f:form method="POST" modelAttribute="search"  name="diachi">
         <f:hidden path="id"/>
       <li>  Tinh <f:input path="tinh"/> </li>
         <li>  Quan Huyen <f:input path="quanHuyen"/> </li>
         <li>   Xa Phuong <f:input path="xaPhuong"/></li>
         <li>   Thon Xom <f:input path="thonXom"/> </li>
         <input type="submit" value="Save"/></li>
     </f:form>
 </ul>
<a href="/diachi/add">Them Khoa</a> <br>

	<c:forEach items="${diachi}" var="d">
<ul>
    <li>Tinh : ${d.tinh} </li>
        <li>	Huyen :	${d.quanHuyen}<li>
        <li>Xa Phuong : ${d.xaPhuong} <li>
        <li>	Thon Xom : ${d.thonXom}<li>
        <li> <a href="/diachi/update/${d.id}">Update</a><li>
        <li>	<a href="/diachi/del/${d.id}">Delete</a><li>
        <c:if test="${model == null }">
    <li>   <a href="/diachi/${d.id}">Show Only</a><li>
    </c:if>
</ul>
	</c:forEach>
<c:if test="${model == 'showOnly' }">
    <a href="/diachi">Show All</a>
</c:if>

<br>


<jsp:include page="../FOOTER.jsp"/>
</body>
</html>