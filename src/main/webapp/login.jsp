<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-sm">
    <div class="card mx-auto    " style="width: 23rem;">
        <div class="card-body">
            <h4>
                <div class="card-title text-center">Log In</div>
            </h4>
            <div class="card-text">
                <form action="login" method="post">
                    <div class="form-group">
                        <div>
                            <input type="email" name="email" class="form-control" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <input type="password" name="password" class="form-control" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="submit" class="btn btn-secondary btn-block">Sign in</button>
                        </div>
                    </div>
                </form>
                <div><a href="/registration">Sing up</a></div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

