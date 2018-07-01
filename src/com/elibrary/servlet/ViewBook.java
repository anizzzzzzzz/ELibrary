package com.elibrary.servlet;

import com.elibrary.beans.Book;
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

@WebServlet(urlPatterns = {"/librarian-home","/view-book"})
public class ViewBook extends HttpServlet {
    public ViewBook(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        if(session.getAttribute(LIBRARIANLOGGEDIN)==null && session.getAttribute(LIBRARIANUSERNAME)==null){
            this.getServletContext().getRequestDispatcher("/views/librarianLogin.jsp").forward(req,resp);
        }
        else {
            Connection connection = DBUtils.getStoredConnection(req);

            String errorString = null;
            List<Book> books = null;
            String successString = req.getParameter("successString");

            try {
                books = BookDao.view(connection);
            } catch (SQLException ex) {
                ex.printStackTrace();
                errorString = ex.getMessage();
            }

            req.setAttribute("errorString", errorString);
            req.setAttribute("successString", successString);
            req.setAttribute("books", books);
            this.getServletContext().getRequestDispatcher("/views/librarianHomePage.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
