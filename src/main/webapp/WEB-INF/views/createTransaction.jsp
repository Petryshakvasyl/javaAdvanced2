<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="header.jsp"/>

<style type="text/css">
    .error {
        color: red;
    }
</style>
<body>


<spring:url value="/transactions" var="transactionUrl"/>
<div class="container">

    <c:choose>
        <c:when test="${transaction.id == null}">
            <h1>Add ${transaction.type}</h1>
        </c:when>
        <c:otherwise>
            <h1>Update ${transaction.type}</h1>
        </c:otherwise>
    </c:choose>
    <br/>
</div>

<div class="container p-4 my-2 border">
    <div class="row">
        <div class="col align-self-center">
            <springForm:form modelAttribute="transaction" action="${transactionUrl}" enctype="multipart/form-data">
                <springForm:hidden path="id"/>
                <springForm:hidden path="type"/>
                <div class="form-group">
                    <label for="amount">Amount</label>
                    <springForm:input path="amount" class="form-control" id="amount" placeholder="Enter amount"
                                      cssErrorClass="form-control is-invalid"/>
                    <springForm:errors path="amount" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="categoryId">Category</label>
                    <springForm:select path="categoryId" class="form-control" id="categoryId"
                                       cssErrorClass="form-control is-invalid">
                        <springForm:option value="${null}" label="-------SELECT CATEGORY-------"/>
                        <springForm:options items="${categories}" itemValue="id" itemLabel="name"/>
                    </springForm:select>
                    <springForm:errors path="categoryId" cssClass="error"/>
                </div>
                <br>
                <div class="form-group">
                    <label for="description">Description</label>
                    <springForm:input path="description" class="form-control" id="description"
                                      placeholder="Descriptiont"/>
                    <springForm:errors path="description" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="date">Date</label>
                        <%--                    <fmt:formatDate value="${transaction.date}" pattern="yyyy-MM-dd" var="transactionDate"/>--%>
                    <springForm:input path="date" class="form-control" id="date"
                                      placeholder="yyyy-MM-dd" cssErrorClass="form-control is-invalid"/>
                    <springForm:errors path="date" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="date">Check</label>
                        <%--                    <fmt:formatDate value="${transaction.date}" pattern="yyyy-MM-dd" var="transactionDate"/>--%>
                    <springForm:input path="check" class="form-control" type="file" id="check"
                                      cssErrorClass="form-control is-invalid"/>
                    <springForm:errors path="date" cssClass="error"/>
                </div>
                <c:choose>
                    <c:when test="${transaction.id == null}">
                        <springForm:button type="submit" class="btn btn-primary">Add</springForm:button>
                    </c:when>
                    <c:otherwise>
                        <springForm:button type="submit" class="btn btn-primary">Update</springForm:button>
                    </c:otherwise>
                </c:choose>

            </springForm:form>
        </div>
    </div>
</div>

<div>
    <img src="/transaction/154/check">
</div>

</body>
</html>

