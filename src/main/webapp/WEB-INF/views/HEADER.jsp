<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="<c:url value="/resources/bootstrap4/css/bootstrap.css" />">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="<c:url value="/resources/bootstrap4/js/bootstrap.min.js" />"></script>
<nav class="navbar navbar-light navbar-expand-xl fixed-top " style="background-color: #e3f2fd;">
    <div class="container">
        <a class="navbar-brand" href="/">Quản lý sinh viên DEMO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container ">
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">

                <c:if test="${idUserAPI==null}">
                    <div class="col-sm-9"></div>
                    <div class="col-sm-3 form-inline my-2 my-lg-0">
                        <a href="/login" class="nav-item nav-link btn-success">Signin</a>
                        <a href="/registation" class="nav-item nav-link btn-success">Signup</a>
                    </div>
                </c:if>
                <c:if test="${idUserAPI!=null}">
                    <div class="col-sm-9 navbar-nav  navbar-nav mr-auto">
                        <a class="nav-item nav-link " href="/thongtinsinhvien">Thong tin sinh vien</a>
                        <a class="nav-item nav-link " href="/nganhdaotao/">Nganh Dao Tao</a>
                        <a class="nav-item nav-link " href="/khoa/">Khoa</a>
                        <a class="nav-item nav-link " href="/lopsv/">Lop</a>
                        <a class="nav-item nav-link " href="/vanbang">Van Bang</a>
                        <a class="nav-item nav-link " href="/giayto/">Giay To</a>
                    </div>
                    <div class="col-sm-3 form-inline my-2 my-lg-0">
                        <a href="/profile?id=${idUserAPI}" class="nav-item nav-link btn-success border-dark">Profile</a>
                        <a href="/logout" class="nav-item nav-link btn-success">Logout</a>
                    </div>
                </c:if>
            </div>

        </div>
    </div>
</nav>

<div class="container" style="margin-top: 60px;">
