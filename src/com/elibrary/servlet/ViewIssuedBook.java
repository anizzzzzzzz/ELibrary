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
import java.util.List;

import static com.elibrary.constant.Constant.LIBRARIANLOGGEDIN;
import static com.elibrary.constant.Constant.LIBRARIANUSERNAME;

@WebServlet(urlPatterns = {"/view-issued-book"})
public class ViewIssuedBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        if(session.getAttribute(LIBRARIANLOGGEDIN)==null && session.getAttribute(LIBRARIANUSERNAME)==null){
            this.getServletContext().getRequestDispatcher("/views/librarianLogin.jsp").forward(req,resp);
        }
        else {
            Connection connection = DBUtils.getStoredConnection(req);
            String errorString = null;
            List<IssueBook> issueBooks = null;
            String errorAtt = (String) req.getAttribute("errorString");
            String successAtt = (String) req.getAttribute("successString");


            try {
                issueBooks = BookDao.viewIssuedBooks(connection);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }

            if (errorString == null) {
                req.setAttribute("errorString", errorAtt);
            } else {
                req.setAttribute("errorString", errorString);
            }
            req.setAttribute("successString", successAtt);
            req.setAttribute("issuedBooks", issueBooks);
            this.getServletContext().getRequestDispatcher("/views/viewIssuedBooks.jsp").forward(req, resp);
        }
    }
}
