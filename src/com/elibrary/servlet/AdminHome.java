package com.elibrary.servlet;

import com.elibrary.beans.Librarian;
import com.elibrary.dao.LibrarianDao;
import com.elibrary.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-home","/view-librarian"})
public class AdminHome extends HttpServlet {
    public AdminHome(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);

        String errorString=null;
        List<Librarian> librarians=null;

        try{
            librarians= LibrarianDao.view(connection);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }

        req.setAttribute("errorString",errorString);
        req.setAttribute("librarians",librarians);

        this.getServletContext().getRequestDispatcher("/views/adminPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
