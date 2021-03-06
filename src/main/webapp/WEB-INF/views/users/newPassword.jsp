<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/30/2018
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../HEADER.jsp"/>
<form class="form-horizontal" role="form" method="POST">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 text-center">
            <h2>Login</h2>
            <hr>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 field-label-responsive">
            <label for="password">Password</label>
        </div>
        <div class="col-md-6">
            <div class="form-group has-danger">
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                    <input type="password" name="password" class="form-control" id="password"
                           placeholder="Password" required>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-control-feedback">
                        <span class="text-danger align-middle">
                            <i class="fa fa-close"> Example Error Message</i>
                        </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 field-label-responsive">
            <label for="password">Confirm Password</label>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon" style="width: 2.6rem">
                        <i class="fa fa-repeat"></i>
                    </div>
                    <input type="password" name="password-confirmation" class="form-control"
                           id="password-confirm" placeholder="Password" required>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="padding-top: 1rem">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <button type="submit" class="btn btn-success"><i class="fa fa-sign-in"></i>Update</button>
        </div>
    </div>
</form>
<jsp:include page="../FOOTER.jsp"/>
</body>
</html>
