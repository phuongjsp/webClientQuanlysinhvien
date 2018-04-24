<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<jsp:include page="../HEADER.jsp"/>
<div class="btn bg-light text-md-center ">
    <a class="mr-sm-5" href="javascript:history.back()">Quay Lại</a>
</div>
<!-- The Modal -->
<div id="noisinhModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <form action="/diachi/addAjax" id="diachinoisinh">
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Tỉnh</span>
                        </div>
                        <input id="tinhns" value="${thongtinsinhvien.diachiByNoiSinh.tinh}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Quận Huyện</span>
                        </div>
                        <input id="quanHuyenns"
                               value="${thongtinsinhvien.diachiByNoiSinh.quanHuyen}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Xã Phường</span>
                        </div>
                        <input id="xaPhuongns" value="${thongtinsinhvien.diachiByNoiSinh.xaPhuong}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Thôn Xóm</span>
                        </div>
                        <input id="thonXomns" value="${thongtinsinhvien.diachiByNoiSinh.thonXom}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <input class="list-group-item-action active text-center" type="submit" value="Lưu"/>
                </li>
            </ul>
        </form>
        <ul class="list-group list-group-item-action active">
            <button class="list-group-item-action active text-center" id="noisinhBtnClose">Hủy</button>
        </ul>
    </div>

</div>


<!-- The Modal -->
<div id="hktcModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <form action="/diachi/addAjax" id="diachihktc">
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Tỉnh</span>
                        </div>
                        <input id="tinhhk" value="${thongtinsinhvien.diachiByHoKhauThuongChu.tinh}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Quận Huyện</span>
                        </div>
                        <input id="quanHuyenhk"
                               value="${thongtinsinhvien.diachiByHoKhauThuongChu.quanHuyen}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Xã Phường</span>
                        </div>
                        <input id="xaPhuonghk" value="${thongtinsinhvien.diachiByHoKhauThuongChu.xaPhuong}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group input-group-sm mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Thôn Xóm</span>
                        </div>
                        <input id="thonXomhk" value="${thongtinsinhvien.diachiByHoKhauThuongChu.thonXom}"
                               type="text" class="form-control" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm">
                    </div>
                </li>
                <li class="list-group-item">
                    <input class="list-group-item-action active text-center" type="submit" value="Lưu"/>
                </li>
            </ul>
        </form>
        <ul class="list-group">
            <button class="list-group-item-action active text-center" id="hktcBtnClose">Huy</button>
        </ul>
    </div>

</div>

<script>

    $(document).ready(function () {

        $('#hktcBtn').click(function () {
            $('#hktcModal').modal('show');
        });
        $('#hktcBtnClose').click(function () {
            $('#hktcModal').modal('hide');
        });
        $('#noisinhBtn').click(function () {
            $('#noisinhModal').modal('show');
        });
        $('#noisinhBtnClose').click(function () {
            $('#noisinhModal').modal('hide');
        });
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
                    $('#noisinhModal').modal('hide');
                    var ns = document.getElementById("noiSinh");
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
                    $('#hktcModal').modal('hide');
                    var hk = document.getElementById("hoKhauThuongChu");
                    hk.value = diachi.id;
                }
            });

            event.preventDefault();
        });

    });

</script>
<div class="container row">
    <div class="col-sm-12 ">
        <form method="POST" name="thongtinsinhvien">
            <ul class="list-group">
                <input type="hidden" name="id" value="${thongtinsinhvien.id}"/>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Mã Sinh Viên</span>
                        </div>
                        <input name="maSv" value="${thongtinsinhvien.maSv}"
                               type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Họ</span>
                        </div>
                        <input name="ho" value="${thongtinsinhvien.ho}"
                               type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                        <div class="input-group-prepend">
                            <span class="input-group-text">Tên</span>
                        </div>
                        <input name="ten" value="${thongtinsinhvien.ten}"
                               type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>

                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ảnh thẻ</span>
                        </div>
                        <input name="anhThe" value="${thongtinsinhvien.anhThe}"
                               type="url" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ngày Sinh</span>
                        </div>
                        <input name="ngaySinh" value="${thongtinsinhvien.ngaySinh}"
                               type="date" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                <li class="list-group-item mb-3">
                    <div class="input-group-prepend">
                        <label class="mr-sm-2 input-group-text" for="inlineFormgioitinh">Giới tính</label>
                        <select name="gioiTinh" class="custom-select mb-2 mr-sm-2 mb-sm-0" id="inlineFormgioitinh">
                            <c:if test="${thongtinsinhvien.gioiTinh==1}">
                                <option value="1" selected>nu</option>
                                <option value="0">nam</option>
                            </c:if>
                            <c:if test="${thongtinsinhvien.gioiTinh==0}">
                                <option value="1">nu</option>
                                <option value="0" selected>nam</option>
                            </c:if>
                            <c:if test="${thongtinsinhvien.gioiTinh==null}">
                                <option value="1">nu</option>
                                <option value="0" selected>nam</option>
                            </c:if>
                        </select>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group-prepend">
                        <input type="button" class="btn btn-primary" id="noisinhBtn" value="Noi Sinh"/>
                        <input type="hidden" name="noiSinh" id="noiSinh" value=""/>
                        <span class="input-group-text" id="noisinhchitiet"> ${thongtinsinhvien.diachiByNoiSinh}</span>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Dân Tộc</span>
                        </div>
                        <input name="maSv" name="danToc" value="${thongtinsinhvien.danToc}"
                               type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="input-group-prepend">
                        <input type="button" class="btn btn-primary" id="hktcBtn" value="Ho Khau thuong chu"/>
                        <input type="hidden" name="hoKhauThuongChu" value="" id="hoKhauThuongChu"/>
                        <span class="input-group-text"
                              id="hktcchitiet">${thongtinsinhvien.diachiByHoKhauThuongChu}</span>
                    </div>
                </li>
                <li class="list-group-item">

                    <label class="mr-sm-2" for="inlineFormNDT">Ngành Đào Tạo</label>
                    <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="nganhDk" id="inlineFormNDT">
                        <c:forEach items="${nganhdaotao}" var="ndt">
                            <c:if test="${thongtinsinhvien.nganhDk == ndt.id}">
                                <option value="${ndt.id}" selected>${ndt.tenNganh} - ${ndt.maNganh}</option>
                            </c:if>
                            <c:if test="${thongtinsinhvien.nganhDk != ndt.id}">
                                <option value="${ndt.id}">${ndt.tenNganh} - ${ndt.maNganh}</option>
                            </c:if>
                        </c:forEach>

                    </select>
                </li>
                <li class="list-group-item">

                    <label class="mr-sm-2" for="inlineFormKH">Khóa Học</label>
                    <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="khoaHoc" id="inlineFormKH">
                        <c:forEach items="${khoahoc}" var="k">
                            <c:if test="${thongtinsinhvien.khoaHoc==k.id}">
                                <option value="${k.id}" selected>${k.tenKhoa} - ${k.maKhoa}</option>
                            </c:if>
                            <c:if test="${thongtinsinhvien.khoaHoc!=k.id}">
                                <option value="${k.id}">${k.tenKhoa} - ${k.maKhoa}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </li>
                <li class="list-group-item">
                    <label class="mr-sm-2" for="inlineFormLop">Lớp học</label>
                    <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="lop" id="inlineFormLop">
                        <c:forEach items="${lopsv}" var="l">
                            <c:if test="${thongtinsinhvien.lop==l.id}">
                                <option value="${l.id}" selected>${l.tenLop} - ${l.maLop}</option>
                            </c:if>
                            <c:if test="${thongtinsinhvien.lop!=l.id}">
                                <option value="${l.id}">${l.tenLop} - ${l.maLop}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ngày Vào Học</span>
                        </div>
                        <input name="ngayVaoHoc" value="${thongtinsinhvien.ngayVaoHoc}"
                               type="date" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default"/>
                    </div>
                </li>
                <li class="list-group-item align-items-center">
                    <input type="submit" class="list-group-item-action active text-center btn btn-success" value="Lưu"/>
                </li>
            </ul>
        </form>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
