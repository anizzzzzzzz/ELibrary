<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 6/27/2018
  Time: 9:00 PM
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
    <jsp:include page="common/navbar/librarianNavBar.jsp"/>
    <div class="container">
        <center><h3>Add Book</h3></center>
        <center><p style="color:red">${errorString}</p></center>
        <center><p style="color:green">${successString}</p></center>
        <br/>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/add-book">
            <div class="form-group">
                <label class="control-label col-sm-2" for="callno">Callno:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="callno" id="callno" placeholder="Enter Callno">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="name" placeholder="Enter Name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="author">Author:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="author" id="author" placeholder="Enter Author">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="publisher">Publisher:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="publisher" id="publisher" placeholder="Enter Publisher">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="quantity">Quantity:</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" name="quantity" id="quantity" placeholder="Enter Quantity">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Save Book</button>
                </div>
            </div>
        </form>
    </div>

</body>
</html>
