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

@WebServlet(urlPatterns = {"/add-book"})
public class AddBook extends HttpServlet {
    public AddBook(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/views/addBook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= DBUtils.getStoredConnection(req);

        String callno=req.getParameter("callno");
        String name=req.getParameter("name");
        String author=req.getParameter("author");
        String publisher=req.getParameter("publisher");
        int quantity= Integer.parseInt(req.getParameter("quantity"));

        String errorString=null;
        String successString=null;

        Book book=new Book(callno,name,author,publisher,quantity);
        try{
            int i=BookDao.save(book,connection);
            if(i>0){
                successString="Book is added";
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            errorString=ex.getMessage();
        }
        req.setAttribute("book",book);

        if(errorString!=null && errorString.length()>0){
            req.setAttribute("errorString",errorString);
        }
        else if(successString!=null){
            req.setAttribute("successString",successString);
        }
        this.getServletContext().getRequestDispatcher("/views/addBook.jsp").forward(req,resp);
    }
}
