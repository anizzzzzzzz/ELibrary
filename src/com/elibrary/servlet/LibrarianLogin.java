package com.elibrary.servlet;

import com.elibrary.beans.Librarian;
import com.elibrary.dao.LibrarianDao;
import com.elibrary.util.DBUtils;

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

import static com.elibrary.constant.Constant.LIBRARIAN;
import static com.elibrary.constant.Constant.LIBRARIANLOGGEDIN;
import static com.elibrary.constant.Constant.LIBRARIANUSERNAME;

@WebServlet(urlPatterns = {"/librarian"})
public class LibrarianLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        if(session.getAttribute(LIBRARIANLOGGEDIN)==null && session.getAttribute(LIBRARIANUSERNAME)==null){
            this.getServletContext().getRequestDispatcher("/views/librarianLogin.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect(req.getContextPath()+"/librarian-home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName= req.getParameter("email");
        String password=req.getParameter("password");
        String remember=req.getParameter("rememberMe");
        boolean rememberMe= "Y".equals(remember);

        boolean librarian=false;
        boolean hasError=false;
        String errorString=null;

        if(userName == null || password ==null || userName.length()==0 || password.length()==0){
            hasError=true;
            errorString="Required username and password";
        }
        else{
            Connection connection= DBUtils.getStoredConnection(req);
            try{
                librarian= LibrarianDao.authenticate(userName,password,connection);

                if(librarian==false){
                    hasError=true;
                    errorString="Username or Password Invalid";
                }
            }
            catch (SQLException ex){
                ex.printStackTrace();
                hasError=true;
                errorString=ex.getMessage();
            }
        }

        if(hasError){
            req.setAttribute("errorString",errorString);
            this.getServletContext().getRequestDispatcher("/views/librarianLogin.jsp").forward(req,resp);
        }
        else{
            HttpSession session=req.getSession();
            session.setAttribute(LIBRARIANLOGGEDIN,"true");
            session.setAttribute(LIBRARIANUSERNAME,userName);

            if(rememberMe){
                DBUtils.storeCookies(resp,userName,password,LIBRARIAN);
            }

            resp.sendRedirect(req.getContextPath()+"/librarian-home");
        }

    }
}
