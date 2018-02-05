<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href= <c:url value="/CSS/my.css"/>>
</head>
<body>

<a href="/logout" type="bu" style="margin-left: 350px " ><h3 style="; color: crimson; font-size: larger">LOGOUT</h3></a>

<div class="page-header" style="width: 880px;margin-left: 250px">
    <h1 style="    margin-left: 220px">Your personal desk dear " ${username} "</h1>
</div>

<table class="table table-bordered" style="width: 500px;margin-left: 450px">
    <p>
    <h3>Your table's list</h3></p>
    <thead>
    <tr>
        <th>name</th>
        <th>status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tablesCafe}" var="table_cafe">
        <tr>
            <td>${table_cafe.name}</td>
            <td>${table_cafe.statuss.name()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<div class="container" style="width: 400px">
    <h2>Please insert ordered product name and amount</h2>
    <form action="/waiter/order/add" name="order">
        <label for="tablesCafe">Table name:</label>
        <select id="tablesCafe" name="table_cafe" class="form-control">
            <c:forEach items="${freeTables}" var="table_cafe">
                <option value="${table_cafe.id}">${table_cafe.name}</option>
            </c:forEach>
        </select>
        <label for="products">product's name:</label>
        <select id="products" name="product" class="form-control">
            <c:forEach items="${products}" var="order">
                <option value="${order.name}">${order.name}</option>
            </c:forEach>
        </select>
        <div class="form-group">
            <label for="amount">amunt:</label>
            <input type="number" class="form-control" id="amount" placeholder="Enter product's amount" name="amount">
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>


    <a href="/logout">logout</a>
</div>

</body>
</html>
