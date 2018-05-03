<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
    <title>Form add and update</title>
</head>
<body>
<jsp:include page="../HEADER.jsp"/>

<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="container row">
    <div class="col-sm-12">
        <form action="" method="post">
            <input type="hidden" name="id" value="${dinhchi.id}"/>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ma Sv</span>
                        </div>
                        <input name="maSv" value="${dinhchi.thongtinsinhvienbyDinhchisinhvien.maSv}"
                               type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
            </ul>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ly Do</span>
                        </div>
                        <input name="lyDo" value="${dinhchi.lyDo}"
                               type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
            </ul>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">tu ngay</span>
                        </div>
                        <input name="tuNgay" value="${dinhchi.tuNgay}"
                               type="date" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
            </ul>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ly Do</span>
                        </div>
                        <input name="denNgay" value="${dinhchi.denNgay}"
                               type="date" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
                <li class="list-group-item align-items-center">
                    <input type="submit" class="list-group-item-action active text-center btn btn-success"
                           value="Lưu"/>
                </li>
            </ul>
        </form>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
