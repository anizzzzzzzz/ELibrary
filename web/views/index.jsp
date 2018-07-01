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

    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 500px;">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="https://library.neura.edu.au/wp-content/uploads/home-page/Library-600x410.jpg" height="500px" width="500px" alt="Library" style="margin:auto;">
            </div>

            <div class="item">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQjLyvdJp5JUWJSceU8IQ8cvC1PPbF9DXH6utLVxdM-JxOkP9X" height="500px" width="500px" alt="Library" style="margin: auto;">
            </div>

            <div class="item">
                <img src="http://www.aaci.org.il/upimages/ebooks.jpg" height="500px" width="500px" alt="Library" style="margin:auto;">
            </div>

            <div class="item">
                <img src="http://schoolville.com/sitefiles/Services/7/elibrary.jpg"  height="500px" width="500px" alt="Library" style="margin:auto;">
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
