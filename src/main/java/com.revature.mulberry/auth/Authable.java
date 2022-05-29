package com.revature.mulberry.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface Authable {

    static boolean checkAuthAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("authAdmin") == null){
            resp.getWriter().write("Unauthorized request - you are not an admin");
            resp.setStatus(401); // Unauthorized
            return false;
        }
        return true;
    }
    static boolean checkAuthCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("authCustomer") == null){
            resp.getWriter().write("Unauthorized request - you are not registered");
            resp.setStatus(401); // Unauthorized
            return false;
        }
        return true;
    }
}