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
    <a class="mr-sm-5" href="/khenthuong/">Quay Lại</a>
</div>
<div class="container row">
    <div class="col-sm-12">
        <form action="" method="post">
            <ul class="list-group">
                <li class="list-group-item" id="formmasv">

                    <div class="input-group mb-3 parent listMasv" style="">
                        <c:if test="${model==null}">
                            <button class="btnAddMasv">Them sinh vien</button>
                            <script>
                                $(document).ready(function () {
                                    var max_fields = 2; //maximum input boxes allowed greater than current boxes
                                    var wrapper = $(".listMasv"); //Fields wrapper
                                    var add_button = $(".btnAddMasv"); //Add button ID

                                    var x = 1; //initlal text box count
                                    $(add_button).click(function (e) { //on add input button click
                                        e.preventDefault();
                                        if (x < max_fields) { //max input box allowed
                                            x++; //text box increment
                                            $(wrapper).append('<div class="input-group mb-3"><input type="text" name="maSv[]"/><a href="#" class="remove_field btn btn-danger">Remove</a></div>'); //add input box
                                            ++max_fields;//increase maximum input boxes

                                        }
                                    });

                                    $(wrapper).on("click", ".remove_field", function (e) { //user click on remove text
                                        e.preventDefault();
                                        $(this).parent('div').remove();
                                        x--;
                                        --max_fields;//decreases maximum input boxes
                                    })
                                });
                            </script>
                            <div class="input-group mb-3">
                                <input type="text" name="maSv[]">
                            </div>
                        </c:if>
                        <c:if test="${model=='update'}">
                            <div class="input-group-prepend">
                                <span class="input-group-text">${khenthuong.thongtinsinhvien.maSv}</span>
                            </div>
                            <div class="input-group-prepend">
                                    <span class="input-group-text">
                                            ${khenthuong.thongtinsinhvien.ho}
                                            ${khenthuong.thongtinsinhvien.ten}
                                    </span>
                            </div>
                        </c:if>

                    </div>

                </li>
                <li class="list-group-item">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Ly Do</span>
                        </div>
                        <input name="lyDo" value="${khenthuong.lyDo}"
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
                <li class="list-group-item">
                    <input class="list-group-item-action active text-center" type="submit" value="Lưu"/>
                </li>
            </ul>

        </form>
    </div>
</div>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
