package com.revature.mulberry.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mulberry.customer.CustomerDao;
import com.revature.mulberry.customer.CustomerServices;
import com.revature.mulberry.customer.CustomerServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            // Make our single ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            CustomerDao customerDao = new CustomerDao();

            CustomerServices customerServices = new CustomerServices(customerDao);

            CustomerServlet customerServlet = new CustomerServlet(customerServices, mapper);

            ServletContext context = sce.getServletContext();
            context.addServlet("CustomerServlet", customerServlet).addMapping("/customer/*");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            ServletContextListener.super.contextDestroyed(sce);
        }
}

