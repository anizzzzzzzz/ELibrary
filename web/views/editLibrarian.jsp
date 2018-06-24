<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 6/24/2018
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-Library</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="common/navbar/adminnavbar.jsp"/>
<div class="container">
    <center><h3>Edit Librarian</h3></center>
    <center><p style="color:red">${errorString}</p></center>
    <br/>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/edit-librarian">
        <div class="form-group" hidden>
            <label class="control-label col-sm-2" for="id">Id:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="id"
                       id="id" placeholder="Enter Id" value="${librarian.id}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name"
                       id="name" placeholder="Enter Name" value="${librarian.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email"
                       id="email" placeholder="Enter email" value="${librarian.email}">
            </div>
        </div>
        <div class="form-group" hidden>
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="password"
                       id="password" placeholder="Enter password" value="${librarian.password}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="mobile">Mobile No:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="mobile" id="mobile"
                       placeholder="Enter Mobile no" value="${librarian.mobile}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
