package com.revature.mulberry.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mulberry.customer.Customer;
import com.revature.mulberry.customer.CustomerServices;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminAuthServlet extends HttpServlet {

    private final CustomerServices customerServices;
    // ObjectMapper provided by jackson
    private final ObjectMapper mapper;

    public AdminAuthServlet(CustomerServices customerServices, ObjectMapper mapper){
        this.customerServices = customerServices;
        this.mapper = mapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
//        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        try {
            // The jackson library has the ObjectMapper with methods to readValues from the HTTPRequest body as an input stream and assign it to the class
            // Trainer reqTrainer = mapper.readValue(req.getInputStream(), Trainer.class);
            LoginCreds loginCreds = mapper.readValue(req.getInputStream(), LoginCreds.class);

            Customer authAdmin = customerServices.authenticateAdmin(loginCreds.getUsername(), loginCreds.getPassword());

            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("authAdmin", authAdmin);

            String payload = mapper.writeValueAsString(authAdmin);

            resp.getWriter().write(payload);
            resp.setStatus(200);
        } catch (Exception e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }
    }
}
