package com.elibrary.servlet;

import com.elibrary.beans.Librarian;
import com.elibrary.conn.ConnectionController;
import com.elibrary.dao.LibrarianDao;
import com.elibrary.util.DBUtils;
import org.omg.IOP.CodecPackage.TypeMismatch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/add-librarian"})
public class AddLibrarian extends HttpServlet {
    public AddLibrarian(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(session.getAttribute("adminLoggedIn")==null &&
                session.getAttribute("adminUsername")==null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/adminLogin.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            this.getServletContext().getRequestDispatcher("/views/addLibrarian.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);

        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
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

        Librarian librarian=new Librarian(name,email,password,mobileNo);

        try {
            LibrarianDao.save(librarian,connection);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }

        req.setAttribute("errorString",errorString);
        req.setAttribute("librarian",librarian);

        if(errorString!=null && errorString.length()>0){
            this.getServletContext().getRequestDispatcher("/views/addLibrarian.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect(req.getContextPath()+"/view-librarian");
        }
    }
}
