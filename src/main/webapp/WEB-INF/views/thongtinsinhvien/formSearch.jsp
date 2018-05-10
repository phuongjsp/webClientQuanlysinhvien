<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../HEADER.jsp"/>
<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="/thongtinsinhvien/add">Them Sinh vien</a>
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<div class="row">
    <div class="col-sm-7">

        <c:forEach items="${properties}" var="p">
            <div class="input-group">
                <div class="input-group-lg">
                    <input type="checkbox" id="${p}" onclick="${p}()"/>
                        ${mapproperties.get(p)}
                </div>
                <i id="propertyBy${p}" class="input-group-lg"></i>
            </div>

        </c:forEach>

    </div>
    <div class="col-sm-5">
        <form id="formorder">
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Sắp xếp theo :</span>
                        </div>
                        <select class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"
                                name="property">
                            <c:forEach items="${listSX}" var="p">
                                <option value="${p}">${mapproperties.get(p)}</option>
                            </c:forEach>
                        </select>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Thứ tự :</span>
                        </div>
                        <select class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"
                                name="order">
                            <option value="asc"> Giảm Dần</option>
                            <option value="desc"> Tăng Dần</option>
                        </select>
                    </div>
                </li>
            </ul>

        </form>
        <form method="post">
            <input type="hidden" name="list" id="listResult" value=""/>
            <input type="submit" class="btn btn-success mr-sm-auto" onclick="call()" value="Tìm Kiếm"/>
        </form>
    </div>
    <div class="col-sm-6 text-xl-center">
        <p>Khen Thuong</p>
        <div>
            Tu <input type="date" id="stdate" onchange="setDate()"/> den <input type="date" id="eddate"
                                                                                onchange="setDate()"/>
            <script type="text/javascript">
                function setDate() {
                    var stdate = new Date(document.getElementById("stdate").value);
                    var eddate = new Date(document.getElementById("eddate").value);
                    var link = document.getElementById("khenthuongByYear");
                    if (stdate != 'Invalid Date' && eddate != 'Invalid Date') {

                        link.setAttribute("href", "/khenthuong/year/"
                            + stdate.getDate() + "-" + stdate.getMonth() + "-" + stdate.getFullYear()
                            + "/" + eddate.getDate() + "-" + eddate.getMonth() + "-" + eddate.getFullYear());
                        link.removeAttribute("style");
                    }
                }
            </script>
            <a href="#" id="khenthuongByYear"
               style="color: currentColor;
              cursor: not-allowed;opacity: 0.5;display: inline-block;  /* For IE11/ MS Edge bug */
              pointer-events: none;text-decoration: none;" class="btn btn-success">Xem</a>
        </div>

        <a href="/khenthuong/" class="btn btn-success">Danh sach toan bo</a>
    </div>
    <div class="col-sm-6 text-xl-center">
        <p>Dinh chi</p>
        <a href="/dinhchi/all" class="btn btn-info">Toan bo danh sach</a>
        <a href="/dinhchi/dangdinhchi" class="btn btn-success">Dang bi dinh chi</a>

    </div>
</div>
<script type="application/javascript">
    var json = "";
    <c:forEach items="${properties}" var="p">

    function ${p}() {
        <c:if test="${p=='nganhDk'}" >
        if (document.getElementById('${p}').checked) {

            var ht = "<form method='post' class='form-check' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + "<select name='value'>";
            <c:forEach items="${nganhdt}" var="n">
            ht += "<option type= value=${n.id}'>${n.tenNganh}</option>${kh}";
            </c:forEach>
            ht += "</select>"
                + " </form>";
            document.getElementById("propertyBy${p}").innerHTML = ht;
        } else {
            document.getElementById("propertyBy${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='lop'}" >
        if (document.getElementById('${p}').checked) {

            var ht = "<form method='post' class='form-check' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + " <select name='value'>";
            <c:forEach items="${lopsv}" var="l">
            ht += "<option  value='${l.id}'>${l.tenLop}</option>${kh}";
            </c:forEach>
            ht += "</select>"
                + " </form>";
            document.getElementById("propertyBy${p}").innerHTML = ht;
        } else {
            document.getElementById("propertyBy${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='khoaHoc'}" >
        if (document.getElementById('${p}').checked) {

            var ht = "<form method='post' class='form-check' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + " <select name='value'>";
            <c:forEach items="${khoahoc}" var="kh">
            ht += "<option value='${kh.id}'>${kh.tenKhoa}</option>${kh}";
            </c:forEach>
            ht += "</select>"
                + " </form>";
            document.getElementById("propertyBy${p}").innerHTML = ht;
        } else {
            document.getElementById("propertyBy${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='NoiSinh' || p=='HoKhauThuongChu'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("propertyBy${p}").innerHTML = "<ul><form method='post' class='form-check' id='form${p}'>"
                + " <input type='hidden' name='diachi' value='${p}'/>"
                + "<li>Tỉnh :<input type='text' name='tinh'  /></li>"
                + "<li>Quận Huyện :<input type='text' name='quanHuyen'  /></li>"
                + "<li>Xã Phường :<input type='text' name='xaPhuong'  /></li>"
                + "<li>Thôn Xóm :<input type='text' name='thonXom'  /></li>"
                + " </form></ul>";
        } else {
            document.getElementById("propertyBy${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='ngaySinh' || p=='ngayVaoHoc'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("propertyBy${p}").innerHTML = "<form class='form-check' method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='between'/>"
                + "  Từ : <input type='date' name='valuelow'/>"
                + "  Đến : <input type='date' name='valuehight'/>"
                + " </form>";
        } else {
            document.getElementById("propertyBy${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='maSv' || p=='ho' || p=='ten' || p=='danToc'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("propertyBy${p}").innerHTML = "<form class='form-check' method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='like'/>"
                + " <input class='form-control' aria-label='Default' aria-describedby='inputGroup-sizing-default' type='text' name='value'/>"
                + " </form>";
        } else {
            document.getElementById("propertyBy${p}").innerHTML = "";
        }
        </c:if>
        <c:if test="${p=='gioiTinh'}" >
        if (document.getElementById('${p}').checked) {
            document.getElementById("propertyBy${p}").innerHTML = "<form method='post' id='form${p}'>"
                + " <input type='hidden' name='property' value='${p}'/>"
                + "<input type='hidden' name='type' value='eq'/>"
                + "  <select name='value'>"
                + "<option value='1'>Nam</option>"
                + "<option value='0'>Nữ</option>"
                + " </select></form>";
        } else {
            document.getElementById("propertyBy${p}").innerHTML = "";
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
        json += ',' + JSON.stringify(obj);

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
        ]
        document.getElementById("listResult").value = '[' + list + ']';
    }
</script>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
