package com.elibrary.servlet;

import com.elibrary.dao.BookDao;
import com.elibrary.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/return-book"})
public class ReturnBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);
        String callno=req.getParameter("callno");
        String studentid=req.getParameter("studentid");
        String errorString=null;
        String successString=null;

        try{
            int i= BookDao.returnBook(callno,studentid,connection);
            if(i>0){
                successString="Book with callno "+callno+" has been returned by student "+studentid;
            }
            else{
                errorString="Error! Cannot be updated";
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            errorString=e.getMessage();
        }

        req.setAttribute("errorString",errorString);
        req.setAttribute("successString",successString);
        resp.sendRedirect("/view-issued-book");
    }
}
