<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 7/1/2018
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <center><h3>Book Lists</h3></center>
        <center><p style="color:red">${errorString}</p></center>
        <br/>
        <c:forEach items="${issuedBooks}" var="issuedBook">
            <div class="card" style="float: left;
                margin: 5px 10px 5px;
                padding:10px 5px 0;
                width: 25rem;
                background-color: #c9e2b3;
                height: 25rem;">
                <div class="card-body">
                    <p class="card-text" style="text-align: center;"><b>Book Call no</b> : ${issuedBook.callno}</p>
                    <p class="card-text" style="text-align: center;"><b>Student Id</b> : ${issuedBook.studentid}</p>
                    <p class="card-text" style="text-align: center;"><b>Student Name</b> : ${issuedBook.studentname}</p>
                    <p class="card-text" style="text-align: center;"><b>Contact No</b> : ${issuedBook.studentmobile}</p>
                    <p class="card-text" style="text-align: center;"><b>Issued</b> : ${issuedBook.issueddate}</p>
                    <p class="card-text" style="text-align: center;"><b>Return Status</b> : ${issuedBook.returnstatus}</p>
                    <c:if test="${issuedBook.returnstatus eq 'no'}">
                        <center>
                            <a href="${pageContext.request.contextPath}/return-book?callno=${issuedBook.callno}&studentid=${issuedBook.studentid}"
                               class="btn btn-primary">Return Book</a>
                        </center>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
