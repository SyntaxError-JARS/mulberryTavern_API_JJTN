package com.revature.mulberry.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mulberry.customer.CustomerDao;
import com.revature.mulberry.customer.CustomerServices;
import com.revature.mulberry.customer.CustomerServlet;
import com.revature.mulberry.menu.MenuDao;
import com.revature.mulberry.menu.MenuServices;
import com.revature.mulberry.menu.MenuServlet;

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
            MenuDao menuDao = new MenuDao();

            CustomerServices customerServices = new CustomerServices(customerDao);
            MenuServices menuServices = new MenuServices(menuDao);

            CustomerServlet customerServlet = new CustomerServlet(customerServices, mapper);
            MenuServlet menuServlet = new MenuServlet(menuServices, mapper);

            ServletContext context = sce.getServletContext();
            context.addServlet("CustomerServlet", customerServlet).addMapping("/customer/*");
            context.addServlet("MenuServlet", menuServlet).addMapping("/menu/*");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            ServletContextListener.super.contextDestroyed(sce);
        }
}

