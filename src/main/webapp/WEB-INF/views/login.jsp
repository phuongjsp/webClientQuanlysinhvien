<%--
  Created by IntelliJ IDEA.
  User: phuongjsp
  Date: 4/27/2018
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="HEADER.jsp"/>
<form class="form-horizontal" role="form" method="POST">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 text-center">
            <h2>Login</h2>
            <hr>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="form-group has-danger">
                <label class="sr-only" for="email">E-Mail Address</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-at"></i></div>
                    <input type="email" name="email" class="form-control" id="email"
                           placeholder="you@example.com" required autofocus>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-control-feedback">
                        <span class="text-danger align-middle">
                            <%--<i class="fa fa-close"></i>--%>
                        </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="form-group">
                <label class="sr-only" for="password">Password</label>
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
                        <!-- Put password error message here -->
                        </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6" style="padding-top: .35rem">
            <div class="form-check mb-2 mr-sm-2 mb-sm-0">
                <label class="form-check-label">
                    <input class="form-check-input" name="remember"
                           type="checkbox">
                    <span style="padding-bottom: .15rem">Remember me</span>
                </label>
            </div>
        </div>
    </div>
    <div class="row" style="padding-top: 1rem">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <button type="submit" class="btn btn-success"><i class="fa fa-sign-in"></i> Login</button>
            <a class="btn btn-link" href="/password/reset">Forgot Your Password?</a>
        </div>
    </div>
</form>
<jsp:include page="FOOTER.jsp"/>
</body>
</html>
