<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 7/1/2018
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
        <center><h3>Issue Book</h3></center>
        <center><p style="color:red">${errorString}</p></center>
        <center><p style="color:green">${successString}</p></center>
        <br/>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/issue-book">
            <div class="form-group">
                <label class="control-label col-sm-2" for="callno">Book Callno:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="callno" id="callno" value="${callno}">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="studentid">Student Id:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="studentid" id="studentid" placeholder="Enter Student Id">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="studentname">Student Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="studentname" id="studentname" placeholder="Enter Student Name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="studentmobile">Student Contact No:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="studentmobile" id="studentmobile" placeholder="Enter Student Contact No">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Issue Book</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
