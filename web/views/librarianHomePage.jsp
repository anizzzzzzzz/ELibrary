<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 6/24/2018
  Time: 9:41 PM
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
        <center><p style="color:green">${successString}</p></center>
        <br/>
        <c:forEach items="${books}" var="book">
            <div class="card" style="float: left;margin: 5px 10px 5px;padding: 5px;width: 25rem;background-color: #c9e2b3;height: 30rem;">
                <div class="card-body">
                    <h3 class="card-title" style="text-align: center;">${book.name}</h3>
                    <p class="card-text" style="text-align: center;">Call no : ${book.callno}</p>
                    <p class="card-text" style="text-align: center;">Author : ${book.author}</p>
                    <p class="card-text" style="text-align: center;">Publisher : ${book.publisher}</p>
                    <p class="card-text" style="text-align: center;">Quantity : ${book.quantity}</p>
                    <p class="card-text" style="text-align: center;">Issued : ${book.issued}</p>
                    <center><a href="${pageContext.request.contextPath}/issue-book?callno=${book.callno}" class="btn btn-primary">Issue Book</a></center>
                </div>
            </div>
        </c:forEach>
    </div>

</body>
</html>
