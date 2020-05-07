<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
</head>
<body>

<form action="/admin/create_product" method="post">

    <h3>Create new product</h3>
    <label>Name:</label> <input name="name" required>
    <br>
    <label>Description: </label> <input name="description">
    <br>
    <label>Price :</label> <input name="price" required>
    <br>
    <input type="submit" value="create">
</form>

</body>
</html>

