<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 6/23/2018
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html style="height: 100%">
<head>
    <title>E-Library</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="min-height: 100%;
      display: flex;
      flex-direction: column;">
    <jsp:include page="/views/common/navbar/navbarhome.jsp"/>

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="<c:url value='/resources/images/library2.jpg'/>" height="500px" width="500px" alt="Library">
            </div>

            <div class="item">
                <img src="<c:url value='/resources/images/library1.jpg'/>" height="500px" width="500px" alt="Library">
            </div>

            <div class="item">
                <img src="<c:url value='/resources/images/admin1.jpg'/>" height="500px" width="500px" alt="Library">
            </div>

            <div class="item">
                <img src="<c:url value='/resources/images/admin2.jpg'/>"  height="500px" width="500px" alt="Library">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
