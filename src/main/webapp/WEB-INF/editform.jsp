<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h2>Edit dish</h2>
    <form class="form-horizontal" action="/edit_save/${dish.id}" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="id"></label>
            <div class="col-sm-10">
                <input type="hidden" class="form-control" id="id"  name="id" value="${dish.id}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="price">Price:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="weight">Weight:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="weight" placeholder="Enter weight" name="weight">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="sale">Sale:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sale" placeholder="Enter sale" name="sale">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Edit save</button>
            </div>
        </div>
    </form>

</div>

</body>
</html>