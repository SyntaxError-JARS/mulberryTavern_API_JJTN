package com.revature.mulberry.creditcard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mulberry.auth.Authable;
import com.revature.mulberry.customer.Customer;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.revature.mulberry.auth.Authable.checkAuthCustomer;

public class CCServlet extends HttpServlet implements Authable {

    private final ObjectMapper mapper;
    private final CCServices ccServices;

    public CCServlet(ObjectMapper mapper, CCServices ccServices) {
        this.mapper = mapper;
        this.ccServices = ccServices;
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doOptions(req, resp);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        if(!checkAuthCustomer(req, resp)) return;
        Customer authCustomer = (Customer) req.getSession().getAttribute("authCustomer");
        CreditCard newCC = new CreditCard();
        CCInitializer initCC = mapper.readValue(req.getInputStream(), CCInitializer.class); // from JSON to Java Object (Pokemon)
        try{
            newCC.setCc_number(initCC.getCc_number());
            newCC.setCc_name(initCC.getCc_name());
            newCC.setCvv(initCC.getCvv());
            newCC.setExp_date(initCC.getExp_date());
            newCC.setZip(initCC.getZip());
//            newCC.setLimit(initCC.getLimit());
            newCC.setCustomer_username(authCustomer);

        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }

        CreditCard persistedCC = ccServices.create(newCC);

        String payload = mapper.writeValueAsString(persistedCC); // Mapping from Java Object (Pokemon) to JSON
        resp.getWriter().write(payload);

        resp.getWriter().write("Your credit card ending with " + persistedCC.lastFourDigits() + " has been added." );
        resp.setStatus(201);
    }
}
