<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 5/4/2018
  Time: 4:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../HEADER.jsp"/>

<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/dinhchi/add">Thêm khen thuong sinh vien</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-form-label-sm">
        <c:if test="${khenthuong==null}">
            Thông tin không hợp lệ vui lòng kiểm tra lại
        </c:if>
        <c:if test="${khenthuong!=null}">
            <ul class="list-group float-sm-left text-center">
            <c:if test="${model!='all'}">
                <li class="list-group-item ">
                    Mã Sv : ${thongtinsinhvien.maSv}
                </li>
                <li class="list-group-item  ">
                    Ho Ten : ${thongtinsinhvien.ho} ${thongtinsinhvien.ten}
                </li>
            </c:if>
            <c:forEach items="${khenthuong}" var="kt">

                <c:if test="${model=='all'}">
                    <li class="list-group-item ">
                        Mã Sv : ${kt.thongtinsinhvien.maSv}
                    </li>
                    <li class="list-group-item  ">
                        Ho Ten : ${kt.thongtinsinhvien.ho} ${kt.thongtinsinhvien.ten}
                    </li>
                </c:if>
                <li class="list-group-item ">
                    Ly do : ${kt.lyDo}
                </li>
                <li class="list-group-item ">
                    Ngay khen thuong:
                    <jsp:useBean id="tungay" class="java.util.Date"/>
                    <jsp:setProperty name="tungay" property="time" value="${kt.ngay}"/>
                    <fmt:formatDate value="${tungay}" pattern="dd - MM - yyyy"/>
                </li>
                <li class="list-group-item  "><a href="/khenthuong/update/${kt.id}">Update</a>
                </li>
                <li class="list-group-item "><a href="/khenthuong/delete/${kt.id}">Delete</a>
                </li>
                </ul>
            </c:forEach>
        </c:if>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
