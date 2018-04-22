<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/22/2018
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0, 0, 0); /* Fallback color */
            background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

<c:forEach items="${properties}" var="p">
    <input type="checkbox" id="${p}" onclick="${p}()">${p}</input> <br>
    <div id="demo${p}"></div>
</c:forEach>
<form id="formorder">
    sap xep theo : <select name="property">
    <c:forEach items="${properties}" var="p">
        <option value="${p}">${p}</option>
    </c:forEach>
</select>
    thu tu <select name="order" id="">
    <option value="asc"> Giam dan</option>
    <option value="desc"> Tang dan</option>
</select>
</form>
<form method="post">

    <input type="hidden" name="list" id="listResult" value=""/>
    <input type="submit" onclick="call()" value="TEST"/>
</form>
<script type="application/javascript">
    var json = "";
    <c:forEach items="${properties}" var="p">

    function ${p}() {
        <c:if test="${p=='nganhDk'}" >
        if (document.getElementById('${p}').checked) {

            var ht = "<form method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + "${p} :<select name='value'>";
            <c:forEach items="${nganhdt}" var="n">
            ht += "<option type= value=${n.id}'>${n.tenNganh}</option>${kh}";
            </c:forEach>
            ht += "</select>"
                + " </form>";
            document.getElementById("demo${p}").innerHTML = ht;
        } else {
            document.getElementById("demo${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='lop'}" >
        if (document.getElementById('${p}').checked) {

            var ht = "<form method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + "${p} :<select name='value'>";
            <c:forEach items="${lopsv}" var="l">
            ht += "<option  value='${l.id}'>${l.tenLop}</option>${kh}";
            </c:forEach>
            ht += "</select>"
                + " </form>";
            document.getElementById("demo${p}").innerHTML = ht;
        } else {
            document.getElementById("demo${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='khoaHoc'}" >
        if (document.getElementById('${p}').checked) {

            var ht = "<form method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + "${p} :<select name='value'>";
            <c:forEach items="${khoahoc}" var="kh">
            ht += "<option value='${kh.id}'>${kh.tenKhoa}</option>${kh}";
            </c:forEach>
            ht += "</select>"
                + " </form>";
            document.getElementById("demo${p}").innerHTML = ht;
        } else {
            document.getElementById("demo${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='NoiSinh' || p=='HoKhauThuongChu'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("demo${p}").innerHTML = "<ul><form method='post' id='form${p}'>"
                + " <input type='hidden' name='diachi' value='${p}'/>"
                + "<li>Tỉnh :<input type='text' name='tinh'  /></li>"
                + "<li>Quận Huyện :<input type='text' name='quanHuyen'  /></li>"
                + "<li>Xã Phường :<input type='text' name='xaPhuong'  /></li>"
                + "<li>Thôn Xóm :<input type='text' name='thonXom'  /></li>"
                + " </form></ul>";
        } else {
            document.getElementById("demo${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='ngaySinh' || p=='ngayVaoHoc'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("demo${p}").innerHTML = "<form method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='between'/>"
                + "${p} tu : <input type='date' name='valuelow'/>"
                + "  den : <input type='date' name='valuehight'/>"
                + " </form>";
        } else {
            document.getElementById("demo${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='maSv' || p=='ho' || p=='ten' || p=='danToc'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("demo${p}").innerHTML = "<form method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='like'/>"
                + "${p} : <input type='text' name='value'/>"
                + " </form>";
        } else {
            document.getElementById("demo${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='gioiTinh'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("demo${p}").innerHTML = "<form method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + "${p} : <select>"
                + "<option value='1'>Nam</option>"
                + "<option value='0'>Nu</option>"
                + " </select></form>";
        } else {
            document.getElementById("demo${p}").innerHTML = "";
        }
        </c:if>


    }

    </c:forEach>
    <c:forEach items="${properties}" var="p">

    function add${p}() {
        var elements = document.getElementById("form${p}").elements;
        var obj = {};
        for (var i = 0; i < elements.length; i++) {
            var item = elements.item(i);
            if (item.value.length > 0) obj[item.name] = item.value;

        }
        json += JSON.stringify(obj);
        ;
    }

    </c:forEach>

    function addorder() {
        var elements = document.getElementById("formorder").elements;
        var obj = {};
        for (var i = 0; i < elements.length; i++) {
            var item = elements.item(i);
            if (item.value.length > 0) obj[item.name] = item.value;

        }
        json = JSON.stringify(obj);
        ;
    }

    function call() {
        addorder();
        <c:forEach items="${properties}" var="p">
        if (document.getElementById('${p}').checked) {
            add${p}();
        }
        </c:forEach>
        var list = [
            json
        ];
        document.getElementById("listResult").value = '[' + list + ']';
    }
</script>
<div>
    ${messages}
</div>
</body>
</html>
