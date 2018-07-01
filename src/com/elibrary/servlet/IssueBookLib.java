package com.elibrary.servlet;

import com.elibrary.beans.IssueBook;
import com.elibrary.dao.BookDao;
import com.elibrary.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static com.elibrary.constant.Constant.LIBRARIANLOGGEDIN;
import static com.elibrary.constant.Constant.LIBRARIANUSERNAME;

@WebServlet(urlPatterns = {"/issue-book"})
public class IssueBookLib extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        if(session.getAttribute(LIBRARIANLOGGEDIN)==null && session.getAttribute(LIBRARIANUSERNAME)==null){
            this.getServletContext().getRequestDispatcher("/views/librarianLogin.jsp").forward(req,resp);
        }
        else {
            String callno = req.getParameter("callno");

            req.setAttribute("callno", callno);
            this.getServletContext().getRequestDispatcher("/views/issueBookPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);
        String callno=req.getParameter("callno");
        String studentid=req.getParameter("studentid");
        String studentname=req.getParameter("studentname");
        long studentmobile= Long.parseLong(req.getParameter("studentmobile"));

        String errorString=null;
        String successString=null;

        try{
            int i= BookDao.issueBook(new IssueBook
                    (callno,
                    studentid,
                    studentname,
                    studentmobile,
                    new java.sql.Date(System.currentTimeMillis())),
                    connection);
            if(i>0){
                successString="Book of callno "+callno+" is issued to student "+studentname;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            errorString="Sorry, unable to issue book.";
        }
        if(errorString!=null && errorString.length()>0){
            req.setAttribute("errorString",errorString);
            resp.sendRedirect("/issue-book?callno="+callno);
        }
        else if(successString!=null){
            req.setAttribute("successString",successString);
            resp.sendRedirect("/librarian-home");
        }

    }
}
