<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<head>
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <springForm:form method="POST" modelAttribute="user" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <springForm:input type="text" path="username" class="form-control" placeholder="Username"
                              autofocus="true"/>
            <springForm:errors path="username"/>
        </div>

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <springForm:input type="email" path="email" class="form-control" placeholder="email"/>
            <springForm:errors path="email"/>
        </div>

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <springForm:input type="text" path="firstName" class="form-control" placeholder="First Name"/>
            <springForm:errors path="firstName"/>
        </div>

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <springForm:input type="text" path="lastName" class="form-control" placeholder="Last Name"/>
            <springForm:errors path="lastName"/>
        </div>

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <springForm:input type="password" path="password" class="form-control" placeholder="Password"/>
            <springForm:errors path="password"/>
        </div>

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <springForm:input type="password" path="passwordConfirm" class="form-control"
                              placeholder="Confirm your password"/>
            <springForm:errors path="passwordConfirm"/>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </springForm:form>

</div>

</body>
</html>
