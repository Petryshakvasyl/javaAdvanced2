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

<div class="container">

    <c:choose>
        <c:when test="${category.id == null}">
            <h1><spring:message code="category.create"/></h1>
        </c:when>
        <c:otherwise>
            <h1><spring:message code="category.update"/></h1>
        </c:otherwise>
    </c:choose>
    <br/>
</div>

<div class="container p-4 my-2 border">
    <div class="row">
        <div class="col align-self-center">
            <springForm:form modelAttribute="category">
                <springForm:hidden path="id"/>
                <springForm:hidden path="type"/>
                <div class="form-group">
                    <label for="amount">Name</label>
                    <springForm:input path="name" class="form-control" id="amount"
                                      cssErrorClass="form-control is-invalid"/>
                    <springForm:errors path="name" cssClass="error"/>
                </div>

                <c:choose>
                    <c:when test="${category.id == null}">
                        <springForm:button type="submit" class="btn btn-primary"><spring:message code="category.create"/></springForm:button>
                    </c:when>
                    <c:otherwise>
                        <springForm:button type="submit" class="btn btn-primary"><spring:message code="category.update"/></springForm:button>
                    </c:otherwise>
                </c:choose>

            </springForm:form>
        </div>
    </div>
</div>

</body>
</html>

