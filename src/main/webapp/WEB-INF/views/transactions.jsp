<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <a href="/transaction/create_form?type=${type}">Create ${type}</a>
    <table class="table table-hover table-responsive">
        <tr>
            <th>Amount</th>
            <th>Date</th>
            <th>Description</th>
            <th>Category</th>
        </tr>

        <c:forEach var="transaction" items="${transactions.getContent()}">
            <tr>
                <td>${transaction.amount}</td>
                <td>${transaction.date}</td>
                <td>${transaction.description}</td>
                <td>${transaction.category.name}</td>
            </tr>
        </c:forEach>
    </table>

    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${transactions.hasPrevious()}">
        <td><a href="/transactions/list?type=${type}&page=${incomePage.getPageable().getPageNumber()-1}">Previous</a>
        </td>
    </c:if>

    <%--For displaying Next link --%>
    <c:if test="${transactions.hasNext()}">
        <td><a href="/transactions/list?type=${type}&page=${incomePage.getPageable().getPageNumber()+1}">Next</a></td>
    </c:if>


</div>
