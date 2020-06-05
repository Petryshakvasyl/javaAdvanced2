<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<script src="${contextPath}/resources/js/header.js"></script>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="margin-bottom: 15px">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">Money-b</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/transactions/list?type=INCOME">My Income</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/transactions/list?type=EXPENSE">My Expense</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/balance">Balance</a>
            </li>
        </ul>
        <form id="logoutForm" class="form-inline my-2 my-lg-0" method="POST" action="${contextPath}/logout">
            <a class="nav-link" onclick="document.forms['logoutForm'].submit()">logout</a>
        </form>

    </div>
</nav>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

