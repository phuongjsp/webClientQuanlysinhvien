<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 5/4/2018
  Time: 4:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <li class="list-group-item" id="formmasv">
                    <button type="button" onclick="themsv()">ThemSv</button>

                    <div class="input-group mb-3 parent" style="">
                        <div id="0"><!--TODO fix here-->
                            <div class="input-group-prepend">
                                <span class="input-group-text">Ma Sv</span>
                            </div>
                            <input name="maSv" value=""
                                   type="text" class="form-control" aria-label="Default"
                                   aria-describedby="inputGroup-sizing-default"/>
                            <button type="button" onclick="huy(0)">Huy</button>
                        </div>

                    </div>

                    <script>
                        var count = 1;
                        var masv = document.getElementById("formmasv");

                        function themsv() {
                            masv = document.getElementById("formmasv");
                            masv.innerHTML = masv.innerHTML
                                + "<div id=\""
                                + count + "\">" +
                                "<div class=\"input-group-prepend\" >" +
                                "<span class=\"input-group-text\">Ma Sv</span>" +
                                "</div>" +
                                "<input name=\"maSv\"" +
                                "type=\"text\" class=\"form-control\" value=\"\" aria-label=\"Default\"" +
                                "aria-describedby=\"inputGroup-sizing-default\"/>\n" +
                                "<button type=\"button\" onclick=\"huy("
                                + count + ")\">Huy</button>";
                            count++;
                        }

                        function huy(id) {
                            document.getElementById(id).remove();
                        }
                    </script>
                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ly Do</span>
                        </div>
                        <input name="lyDo"
                               type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> ngay</span>
                        </div>
                        <input name="ngay" value="${now}"
                               type="date" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
