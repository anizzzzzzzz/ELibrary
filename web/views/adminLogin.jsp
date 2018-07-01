<%@ page import="static com.elibrary.util.DBUtils.ATT_NAME_PASSWORD_ADMIN" %>
<%@ page import="static com.elibrary.util.DBUtils.ATT_NAME_USER_NAME_ADMIN" %>
<%--
  Created by IntelliJ IDEA.
  User: Nitans
  Date: 6/24/2018
  Time: 9:06 AM
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
<%
    String username=null,password=null;
    Cookie[] cookies=request.getCookies();
    if(cookies!=null)
    {
        for(int i=0;i<cookies.length;i++)
        {
            if(cookies[i].getName().equals(ATT_NAME_USER_NAME_ADMIN))
            {
                username=cookies[i].getValue();
            }

            if(cookies[i].getName().equals(ATT_NAME_PASSWORD_ADMIN))
            {
                password=cookies[i].getValue();
            }
        }
    }
%>
<body>
    <jsp:include page="/views/common/navbar/navbarhome.jsp"/>
    <div class="container">
        <center><h3>Admin Login</h3></center>
        <center> <p style="color: red;">${errorString}</p></center>
        <br/>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin">
            <div class="form-group">
                <label class="control-label col-sm-2" for="email">Email:</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter email"
                           value="<%if(username!=null){out.println(username);}%>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pwd">Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="pwd" placeholder="Enter password"
                           value="<%if(password!=null){out.println(password);}%>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="rememberMe" value="Y"> Remember me</label>
                    </div>
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
