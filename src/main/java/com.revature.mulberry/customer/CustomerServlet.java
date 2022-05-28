package com.revature.mulberry.customer;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {

    private final CustomerServices customerServices;
    private final ObjectMapper mapper;


    public CustomerServlet(CustomerServices customerServices, ObjectMapper mapper) {
        this.customerServices = customerServices;
        this.mapper = mapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Customer customer = mapper.readValue(req.getInputStream(), Customer.class); // from JSON to Java Object (Pokemon)
        Customer persistedCustomer = customerServices.create(customer);

        String payload = mapper.writeValueAsString(persistedCustomer); // Mapping from Java Object (Pokemon) to JSON

        resp.getWriter().write("Persisted the provided customer as show below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }
}
