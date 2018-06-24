package com.elibrary.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.elibrary.constant.Constant.LIBRARIANLOGGEDIN;
import static com.elibrary.constant.Constant.LIBRARIANUSERNAME;

@WebServlet(urlPatterns = {"/logout-librarian"})
public class LibrarianLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        session.setAttribute(LIBRARIANLOGGEDIN,null);
        session.setAttribute(LIBRARIANUSERNAME,null);

        resp.sendRedirect(req.getContextPath()+"/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
