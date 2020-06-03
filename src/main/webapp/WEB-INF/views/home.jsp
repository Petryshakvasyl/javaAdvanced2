<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2> Current balance: ${balance}</h2>
</div>

<div class="row justify-content-center">
    <div class="justify-content-center">
        <button class="btn btn-success btn-lg" onclick="window.location='/transaction/create_form?type=INCOME'">add
            income
        </button>
        <button class="btn btn-danger btn-lg" onclick="window.location='/transaction/create_form?type=EXPENSE'">add
            expense
        </button>
    </div>
</div>

