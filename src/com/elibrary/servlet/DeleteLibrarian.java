package com.elibrary.servlet;

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

@WebServlet(urlPatterns = {"/delete-librarian"})
public class DeleteLibrarian extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);

        int id=Integer.parseInt(req.getParameter("id"));
        String errorString=null;

        try{
            LibrarianDao.delete(id,connection);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }

        if(errorString!=null){
            req.setAttribute("errorString", errorString);
            this.getServletContext().getRequestDispatcher("/views/deleteErrorPage.jsp");
        }
        else{
            resp.sendRedirect("/admin-home");
        }
    }
}
