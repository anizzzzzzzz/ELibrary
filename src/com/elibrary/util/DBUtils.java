package com.elibrary.util;

import com.elibrary.constant.Constant;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class DBUtils {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    private static final String ATT_NAME_USER_NAME_LIBRARIAN = "ATTRIBUTE_FOR_STORE_USER_NAME_LIBRARIAN_IN_COOKIE";
    private static final String ATT_NAME_PASSWORD_LIBRARIAN = "ATTRIBUTE_FOR_STORE_PASSWORD_LIBRARIAN_IN_COOKIE";
    private static final String ATT_NAME_USER_NAME_ADMIN = "ATTRIBUTE_FOR_STORE_USER_NAME_ADMIN_IN_COOKIE";
    private static final String ATT_NAME_PASSWORD_ADMIN = "ATTRIBUTE_FOR_STORE_PASSWORD_ADMIN_IN_COOKIE";

    public static void storeConnection(ServletRequest request, Connection connection){
        request.setAttribute(ATT_NAME_CONNECTION, connection);
    }

    // Get the Connection object has been stored in attribute of the request.
    public static Connection getStoredConnection(ServletRequest request){
        Connection connection=(Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return connection;
    }

    // Store info in Cookie
    public static void storeCookies(HttpServletResponse response, String username,String password,String role){
        Cookie cookieUserName, cookiePassword;
        if(role.equalsIgnoreCase(Constant.ADMIN)) {
            cookieUserName = new Cookie(ATT_NAME_USER_NAME_ADMIN, username);
            cookiePassword = new Cookie(ATT_NAME_PASSWORD_ADMIN, password);
        }
        else{
            cookieUserName = new Cookie(ATT_NAME_USER_NAME_LIBRARIAN, username);
            cookiePassword = new Cookie(ATT_NAME_PASSWORD_LIBRARIAN, password);
        }
        // 1 day (Converted to seconds)
        cookieUserName.setMaxAge(24*60*60);
        cookiePassword.setMaxAge(24*60*60);
        response.addCookie(cookieUserName);
        response.addCookie(cookiePassword);
    }

    public static String getUserNameInCookie(HttpServletRequest request, String role){
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(role.equalsIgnoreCase(Constant.ADMIN)) {
                    if (ATT_NAME_USER_NAME_ADMIN.equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                    if(ATT_NAME_PASSWORD_ADMIN.equals(cookie.getName())){
                        return cookie.getValue();
                    }
                }
                else{
                    if (ATT_NAME_USER_NAME_LIBRARIAN.equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                    if(ATT_NAME_PASSWORD_LIBRARIAN.equals(cookie.getName())){
                        return cookie.getValue();
                    }
                }
            }
        }
        return null;
    }

    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response, String role){
        Cookie cookieUserName, cookiePassword;
        if(role.equalsIgnoreCase(Constant.ADMIN)) {
            cookieUserName = new Cookie(ATT_NAME_USER_NAME_ADMIN, null);
            cookiePassword = new Cookie(ATT_NAME_PASSWORD_ADMIN, null);
        }
        else{
            cookieUserName = new Cookie(ATT_NAME_USER_NAME_LIBRARIAN, null);
            cookiePassword = new Cookie(ATT_NAME_PASSWORD_LIBRARIAN, null);
        }
        cookieUserName.setMaxAge(0);
        cookiePassword.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
}
