<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.10.2017
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>com.tsvietkovich</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>The list of all dishes</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Weight</th>
            <th>Sale</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="dish" items="${list}">
        <tr>
            <td>${dish.id}</td>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td>${dish.weight}</td>
            <td>${dish.sale}</td>
            <td>
                <div class="checkbox">
                    <labe><input type="checkbox" name="toDelete[]" value="${dish.id}" id="checkbox_${dish.id}"/></labe>
                </div>
            </td>
            <td><a href="/edit_dish/${dish.id}" class="btn btn-info" role="button">Edit</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="col-sm-offset-2 col-sm-10">
    <button type="button" id="delete_dish" class="btn btn-info">Delete selected</button>
    <a href="/" class="btn btn-info" role="button">Add dish</a>
</div>
<script>
    $('#delete_dish').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/delete_selected", data, function(data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>