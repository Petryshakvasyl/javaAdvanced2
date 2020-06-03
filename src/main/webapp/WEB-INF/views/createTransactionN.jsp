<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="header.jsp"/>

<style type="text/css">
    .error {
        color: red;
    }
</style>
<body>

<form action="/transactions" method="POST">
    <input name="id" hidden/>
    <div class="form-group">
        <label for="amount">Choose Type</label>
        <select name="type" class="form-control" id="type">
            <option>INCOME</option>
            <option>EXPENSE</option>
        </select>
    </div>
    <div class="form-group">
        <label for="amount">Amount</label>
        <input name="amount" class="form-control" id="amount" placeholder="Enter amount"/>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <input name="description" class="form-control" id="description" placeholder="Descriptiont"/>
    </div>
    <div class="form-group">
        <label for="date">Date</label>
        <input name="date" type="date" class="form-control" id="date"/>
    </div>
    <div class="form-group">
        <label for="categoryId">Category</label>
        <select name="categoryId" class="form-control" id="categoryId">
            <c:forEach items="${categories}" var="category">
                <option value=${category.id}>${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <input type="submit" class="btn btn-primary" value="Create"/>
</form>
</body>
</html>

