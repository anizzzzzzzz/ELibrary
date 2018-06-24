<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 6/24/2018
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">eLibrary</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/view-librarian">View Librarians</a></li>
                <li><a href="${pageContext.request.contextPath}/add-librarian">Add Libraran</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/adminLogout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
