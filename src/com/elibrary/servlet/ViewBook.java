package com.elibrary.servlet;

import com.elibrary.beans.Book;
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
import java.util.List;

@WebServlet(urlPatterns = {"/librarian-home","/view-book"})
public class ViewBook extends HttpServlet {
    public ViewBook(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);

        String errorString=null;
        List<Book> books=null;

        try {
            books= BookDao.view(connection);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }

        req.setAttribute("errorString",errorString);
        req.setAttribute("books",books);
        this.getServletContext().getRequestDispatcher("/views/librarianHomePage.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
