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
    <h1>Get dishes by category</h1>
    <br>
    <h2>Get dishes by prices</h2>
    <form class="form-horizontal" action="/dishes_between" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="from">From price:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="from" placeholder="Enter price" name="from">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="to">To price:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="to" placeholder="Enter price" name="to">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Check</button>
            </div>
        </div>
    </form>
    <br>
    <h2>Get sale dishes</h2>
    <form class="form-horizontal" action="/viewSale" method="POST">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Check</button>
            </div>
        </div>
    </form>
    <br>
    <h2>Get dishes under weight</h2>
    <form class="form-horizontal" action="/dishes_underWeight" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="under">Under weight:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="under" placeholder="Enter weight" name="under">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Check</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
