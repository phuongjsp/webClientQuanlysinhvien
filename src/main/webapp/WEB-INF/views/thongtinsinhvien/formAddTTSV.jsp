<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/10/2018
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form add Khoa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
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


<!-- The Modal -->
<div id="noisinhModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <form action="/diachi/addAjax" id="diachinoisinh">
            <ul>
                <li>tinh <input type="text" id="tinhns" value="${thongtinsinhvien.diachiByNoiSinh.tinh}"/></li>
                <li> quan Huyen <input type="text" id="quanHuyenns" value="${thongtinsinhvien.diachiByNoiSinh.quanHuyen}"/></li>
                <li> xa Phuong <input type="text" id="xaPhuongns" value="${thongtinsinhvien.diachiByNoiSinh.xaPhuong}"/></li>
                <li> thon xom <input type="text" id="thonXomns" value="${thongtinsinhvien.diachiByNoiSinh.thonXom}"/></li>
                <li><input type="submit" value="save"></li>
            </ul>
        </form>
    </div>

</div>


<!-- The Modal -->
<div id="hktcModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <form action="/diachi/addAjax" id="diachihktc">
            <ul>
                <li>tinh <input type="text" id="tinhhk" value="${thongtinsinhvien.diachiByHoKhauThuongChu.tinh}"/></li>
                <li> quan Huyen <input type="text" id="quanHuyenhk" value="${thongtinsinhvien.diachiByHoKhauThuongChu.quanHuyen}"/></li>
                <li> xa Phuong <input type="text" id="xaPhuonghk" value="${thongtinsinhvien.diachiByHoKhauThuongChu.xaPhuong}"/></li>
                <li> thon xom <input type="text" id="thonXomhk" value="${thongtinsinhvien.diachiByHoKhauThuongChu.thonXom}"/></li>
                <li><input type="submit" value="save"></li>
            </ul>
        </form>
    </div>

</div>

<script>
    $(document).ready(function () {

        $('#diachinoisinh').submit(function (event) {

            var tinh = $('#tinhns').val();
            var quanHuyen = $('#quanHuyenns').val();
            var xaPhuong = $('#xaPhuongns').val();
            var thonXom = $('#thonXomns').val();
            var json = {"tinh": tinh, "quanHuyen": quanHuyen, "xaPhuong": xaPhuong, "thonXom": thonXom};

            $.ajax({
                url: $("#diachinoisinh").attr("action"),
                data: JSON.stringify(json),
                type: "POST",

                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (diachi) {
                    var respContent = "";
                    respContent = diachi.tinh + " | " + diachi.quanHuyen + " | " + diachi.xaPhuong + " | " + diachi.thonXom;
                    $("#noisinhchitiet").html(respContent);
                    var modal = document.getElementById('noisinhModal');
                    modal.style.display = "none";
                    var btn = document.getElementById("noisinhBtn");
                    var ns = document.getElementById("noiSinh");
                    btn.disabled = true;
                    ns.value = diachi.id;
                }
            });

            event.preventDefault();
        });
        $('#diachihktc').submit(function (event) {

            var tinh = $('#tinhhk').val();
            var quanHuyen = $('#quanHuyenhk').val();
            var xaPhuong = $('#xaPhuonghk').val();
            var thonXom = $('#thonXomhk').val();
            var json = {"tinh": tinh, "quanHuyen": quanHuyen, "xaPhuong": xaPhuong, "thonXom": thonXom};

            $.ajax({
                url: $("#diachihktc").attr("action"),
                data: JSON.stringify(json),
                type: "POST",

                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (diachi) {
                    var respContent = "";
                    respContent = diachi.tinh + " | " + diachi.quanHuyen + " | " + diachi.xaPhuong + " | " + diachi.thonXom;
                    $("#hktcchitiet").html(respContent);
                    var modal = document.getElementById('hktcModal');
                    modal.style.display = "none";
                    var btn = document.getElementById("hktcBtn");
                    var hk = document.getElementById("hoKhauThuongChu");
                    btn.disabled = true;
                    hk.value = diachi.id;
                }
            });

            event.preventDefault();
        });

    });
    // Get the modal
    var modalnoisinh = document.getElementById('noisinhModal');
    var hktcModal = document.getElementById('hktcModal');

    // When the user clicks the button, open the modal
    function btnNoiSinhClick() {
        modalnoisinh.style.display = "block";
    }

    function btnHoKhauClick() {
        hktcModal.style.display = "block";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

<form method="POST"   name="thongtinsinhvien">
    <ul><input type="hidden"  name="id" value="${thongtinsinhvien.id}"/>
        <li> ma Sinh vien<input type="text" name="maSv" value="${thongtinsinhvien.maSv}"/></li>
        <li> ho <input type="text" name="ho" value="${thongtinsinhvien.ho}"/>
            Ten <input type="text" name="ten" value="${thongtinsinhvien.ten}"/></li>
        <li>Anh The : <input type="text" name="anhThe" value="${thongtinsinhvien.anhThe}"/></li>

        <li> Ngay sinh <input type="date" name="ngaySinh" value="${thongtinsinhvien.ngaySinh}"/></li>
        <li> Gioi tinh <select name="gioiTinh"  >
            <c:if test="${thongtinsinhvien.gioiTinh==1}">
                <option value="1" selected>nu</option>
                <option value="0">nam</option>
            </c:if>
            <c:if test="${thongtinsinhvien.gioiTinh==0}">
                <option value="1" >nu</option>
                <option value="0" selected>nam</option>
            </c:if>
            <c:if test="${thongtinsinhvien.gioiTinh==null}">
                <option value="1" >nu</option>
                <option value="0" selected>nam</option>
            </c:if>
        </select></li>
        <li><input type="button" id="noisinhBtn" onclick="btnNoiSinhClick()" value="Noi Sinh"/>

            <span id="noisinhchitiet"> ${thongtinsinhvien.diachiByNoiSinh}</span>
        </li>
        <li><input type="text" name="danToc" value="${thongtinsinhvien.danToc}"/>
            <input  type="hidden" name="noiSinh" id="noiSinh" value=""/>
            <input type="hidden"  name="hoKhauThuongChu" value="" id="hoKhauThuongChu" />
        </li>

        <li>
            <input type="button" id="hktcBtn" onclick="btnHoKhauClick()" value="Ho Khau thuong chu"/>

            <span id="hktcchitiet">${thongtinsinhvien.diachiByHoKhauThuongChu}</span>
        </li>
        <li> Nganh dao tao <select name="nganhDk" >
            <c:forEach items="${nganhdaotao}" var="ndt">
                <c:if test="${thongtinsinhvien.nganhDk == ndt.id}">
                    <option value="${ndt.id}" selected>${ndt.tenNganh} - ${ndt.maNganh}</option>
                </c:if>
                <c:if test="${thongtinsinhvien.nganhDk != ndt.id}">
                    <option value="${ndt.id}" >${ndt.tenNganh} - ${ndt.maNganh}</option>
                </c:if>
            </c:forEach>
        </select></li>
        <li> Khoa <select  name="khoaHoc" >
            <c:forEach items="${khoahoc}" var="k">
                <c:if test="${thongtinsinhvien.khoaHoc==k.id}">
                    <option  value="${k.id}" selected>${k.tenKhoa} - ${k.maKhoa}</option>
                </c:if>
                <c:if test="${thongtinsinhvien.khoaHoc!=k.id}">
                    <option  value="${k.id}" >${k.tenKhoa} - ${k.maKhoa}</option>
                </c:if>
            </c:forEach>
        </select></li>
        <li> Lop <select name="lop" >
            <c:forEach items="${lopsv}" var="l">
                <c:if test="${thongtinsinhvien.lop==l.id}">
                    <option value="${l.id}" selected>${l.tenLop} - ${l.maLop}</option>
                </c:if>
                <c:if test="${thongtinsinhvien.lop!=l.id}">
                    <option value="${l.id}" >${l.tenLop} - ${l.maLop}</option>
                </c:if>
            </c:forEach>
        </select></li>
        <li><input name="ngayVaoHoc" type="date" value="${thongtinsinhvien.ngayVaoHoc}"/></li>
        <li><input type="submit" value="Save"/></li>
    </ul>
</form>
</body>
</html>
