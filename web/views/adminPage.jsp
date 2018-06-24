<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 6/24/2018
  Time: 11:28 AM
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
    <jsp:include page="common/navbar/adminnavbar.jsp"/>
    <div class="container">
        <center><h3>Librarian Lists</h3></center>
        <center><p style="color:red">${errorString}</p></center>
        <br/>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${librarians}" var="librarian">
                    <tr>
                        <td>${librarian.id}</td>
                        <td>${librarian.name}</td>
                        <td>${librarian.email}</td>
                        <td>${librarian.mobile}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit-librarian?id=${librarian.id}">Edit</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/delete-librarian?id=${librarian.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
