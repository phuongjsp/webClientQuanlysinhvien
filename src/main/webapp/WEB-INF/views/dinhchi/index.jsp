<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 5/3/2018
  Time: 3:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dinh chi sinh vien page</title>
</head>
<body>
<jsp:include page="../HEADER.jsp"/>

<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/dinhchi/add">Thêm Quyet dinh dinh chi sinh vien</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-form-label-sm">
        <c:if test="${dinhchi==null}">
            Thông tin không hợp lệ vui lòng kiểm tra lại
        </c:if>
        <c:if test="${dinhchi!=null}">
            <c:forEach items="${dinhchi}" var="dc">
                <ul class="list-group float-sm-left text-center">
                    <li class="list-group-item ">
                        Mã Sv : ${dc.thongtinsinhvienbyDinhchisinhvien.maSv}
                    </li>
                    <li class="list-group-item  ">
                        Ho Ten : ${dc.thongtinsinhvienbyDinhchisinhvien.ho} ${dc.thongtinsinhvienbyDinhchisinhvien.ten}
                    </li>
                    <li class="list-group-item ">
                        Ly do : ${dc.lyDo}
                    </li>
                    <li class="list-group-item ">
                        Thoi gian dinh chi :
                        tu
                        <jsp:useBean id="tungay" class="java.util.Date"/>
                        <jsp:setProperty name="tungay" property="time" value="${dc.tuNgay}"/>
                        <fmt:formatDate value="${tungay}" pattern="dd - MM - yyyy"/>
                        den
                        <jsp:useBean id="denngay" class="java.util.Date"/>
                        <jsp:setProperty name="denngay" property="time" value="${dc.denNgay}"/>
                        <fmt:formatDate value="${denngay}" pattern="dd - MM - yyyy"/>
                    </li>
                    <li class="list-group-item  "><a href="/dinhchi/update/${dc.id}">Update</a>
                    </li>
                    <li class="list-group-item "><a href="/dinhchi/delete/${dc.id}"">Delete</a>
                    </li>
                </ul>
            </c:forEach>
        </c:if>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
