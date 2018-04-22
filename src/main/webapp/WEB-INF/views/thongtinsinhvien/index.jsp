<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Danh sach Khoa</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border-bottom-color: red;
        }

        li {
            margin-left: 20px;
        }

        #andthe {
            width: 50px;
            height: 50px;
            margin-top: 2px;
            margin-bottom: 2px
        }
    </style>
</head>
<body>
<%--${khoa.tenKhoa}--%>

<a href="/thongtinsinhvien/add">Them Khoa</a> <br>

<c:forEach items="${thongtinsinhvien}" var="t">
    <ul>
        <li>ma SV ${t.maSv}</li>
        <li>Ho : ${t.ho}</li>
        <li>Ten : ${t.ten}</li>
        <li><img id="andthe" src="${t.anhThe}" alt="${t.maSv}"></li>
        <li>Gioi tinh : ${t.gioiTinh==1?'nam':'nu'}</li>
        <li>Dan toc : ${t.danToc}</li>
        <li>Ngay Sinh :
            <fmt:formatDate value="${t.ngaySinh}" pattern="dd - MM - yyyy"/>
        </li>
        <li>noi sinh : ${t.diachiByNoiSinh.tinh} -${t.diachiByNoiSinh.quanHuyen}
            -${t.diachiByNoiSinh.xaPhuong}-${t.diachiByNoiSinh.thonXom}</li>
        <li>Ho Khau thuong chu : ${t.diachiByHoKhauThuongChu.tinh} -${t.diachiByHoKhauThuongChu.quanHuyen}
            -${t.diachiByHoKhauThuongChu.xaPhuong}-${t.diachiByHoKhauThuongChu.thonXom}</li>
        <li>Nganh dk : ${t.nganhdaotaoByNganhDk.tenNganh} -${t.nganhdaotaoByNganhDk.maNganh}  </li>
        <li>Khoa : ${t.khoaByKhoaHoc.tenKhoa} - ${t.khoaByKhoaHoc.maKhoa} </li>
        <li>Lop : ${t.lopsvByLop.tenLop} -${t.lopsvByLop.maLop}</li>
        <li>Ngay vao hoc : ${t.ngayVaoHoc}</li>
        <c:forEach items="${listTTT}" var="listttt">
            <c:if test="${listttt.idSv==t.id}">
                <li>${listttt.tenThongTin} :${listttt.thongTin} </li>
            </c:if>
        </c:forEach>
        <c:forEach items="${listTTGD}" var="listttgd">
            <c:if test="${listttgd.idSv==t.id}">
                <li>Quan he : ${listttgd.quanHe}  </li>
                <li>Ten : ${listttgd.sdt}</li>
                <li>nghe Nghie : ${listttgd.ngheNghiep}</li>
            </c:if>
        </c:forEach>
        <li><a href="/SvCoVb/maSv-${t.maSv}">Van Bang</a></li>
        <li><a href="/thongtinsinhvien/update/${t.maSv}">Update</a></li>

        <li><a href="/thongtinsinhvien/del/${t.maSv}">Delete</a></li>
        <li><a href="/sinhviencogiayto/maSv-${t.maSv}">Thong tin giay to</a></li>
        <li><a href="/thongtinthem/add/${t.maSv}">Them thong tin</a></li>

    </ul>
</c:forEach>
<c:if test="${model == 'only' }">
    <a href="/thongtinsinhvien/">Show All</a>
</c:if>

<br>


</body>
</html>