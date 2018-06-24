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

@WebServlet(urlPatterns = {"/edit-librarian"})
public class EditLibrarian extends HttpServlet {
    public EditLibrarian(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);

        int id=Integer.parseInt(req.getParameter("id"));
        Librarian librarian=null;
        String errorString=null;

        try {
            librarian= LibrarianDao.viewById(id,connection);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }

        if(errorString!=null && librarian ==null){
            resp.sendRedirect(req.getContextPath()+"/admin-home");
            return;
        }

        req.setAttribute("errorString", errorString);
        req.setAttribute("librarian",librarian);

        this.getServletContext().getRequestDispatcher("/views/editLibrarian.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=DBUtils.getStoredConnection(req);
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        System.out.println(req.getParameter("mobile"));
        String mobile=req.getParameter("mobile");
        long mobileNo=0L;

        String errorString=null;

        try {
            mobileNo=Long.parseLong(mobile);
        }
        catch (Exception ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }

        Librarian librarian=new Librarian(id,name,email,password,mobileNo);

        try {
            LibrarianDao.update(librarian,connection);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }

        req.setAttribute("errorString",errorString);
        req.setAttribute("librarian",librarian);

        if(errorString!=null && errorString.length()>0){
            this.getServletContext().getRequestDispatcher("/views/editLibrarian.jsp");
        }
        else{
            resp.sendRedirect(req.getContextPath()+"/view-librarian");
        }
    }
}
