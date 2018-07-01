package com.elibrary.servlet;

import com.elibrary.constant.Constant;
import com.elibrary.util.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin"})
public class AdminLogin extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        if(session.getAttribute("adminLoggedIn")==null &&
                session.getAttribute("adminUsername")==null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/adminLogin.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/admin-home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("email");
        String password=req.getParameter("password");
        String rememberMeStr=req.getParameter("rememberMe");
        boolean rememberMe="Y".equals(rememberMeStr);

        boolean hasError=false;
        String errorString=null;
        if(userName == null || password ==null || userName.length()==0 || password.length()==0){
            hasError=true;
            errorString="Required username and password";
        }
        else{
            if(!userName.equals("admin@elibrary.com") && !password.equals("admin123")){
                hasError=true;
                errorString="Provided username and password doesnt match";
            }
        }

        if(hasError){
            req.setAttribute("errorString",errorString);
            req.setAttribute("user",userName);

            this.getServletContext().getRequestDispatcher("/views/adminLogin.jsp").forward(req,resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("adminLoggedIn", "true");
            session.setAttribute("adminUsername", userName);

            if(rememberMe){
                DBUtils.storeCookies(resp,userName,password, Constant.ADMIN);
            }

            resp.sendRedirect(req.getContextPath()+"/admin-home");
        }
//            else{
//                hasError=true;
//                errorString="Provided username and password doesnt match";
//            }
//        }
    }
}
