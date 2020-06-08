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
        <div class="form-group">
            <springForm:input path="username" class="form-control" placeholder="Username"
                              autofocus="true" cssErrorClass="form-control is-invalid"/>
            <springForm:errors path="username" cssClass="has-error"/>
        </div>

        <div class="form-group">
            <springForm:input path="email" class="form-control" placeholder="email"
                              cssErrorClass="form-control is-invalid"/>
            <springForm:errors path="email" cssClass="has-error"/>
        </div>

        <div class="form-group">
            <springForm:input type="text" path="firstName" class="form-control" placeholder="First Name"
                              cssErrorClass="form-control is-invalid"/>
            <springForm:errors path="firstName" cssClass="has-error"/>
        </div>

        <div class="form-group">
            <springForm:input type="text" path="lastName" class="form-control" placeholder="Last Name"
                              cssErrorClass="form-control is-invalid"/>
            <springForm:errors path="lastName" cssClass="has-error"/>
        </div>

        <div class="form-group">
            <springForm:input type="password" path="password" class="form-control" placeholder="Password"
                              cssErrorClass="form-control is-invalid"/>
            <springForm:errors path="password" cssClass="has-error"/>
        </div>

        <div class="form-group">
            <springForm:input type="password" path="passwordConfirm" class="form-control"
                              placeholder="Confirm your password"
                              cssErrorClass="form-control is-invalid"/>
            <springForm:errors path="passwordConfirm" cssClass="has-error"/>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </springForm:form>

</div>

</body>
</html>
