package com.revature.mulberry.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mulberry.auth.AdminAuthServlet;
import com.revature.mulberry.auth.CustomerAuthServlet;
import com.revature.mulberry.creditcard.CCDao;
import com.revature.mulberry.creditcard.CCServices;
import com.revature.mulberry.creditcard.CCServlet;
import com.revature.mulberry.customer.CustomerDao;
import com.revature.mulberry.customer.CustomerServices;
import com.revature.mulberry.customer.CustomerServlet;
import com.revature.mulberry.menu.MenuDao;
import com.revature.mulberry.menu.MenuServices;
import com.revature.mulberry.menu.MenuServlet;
import com.revature.mulberry.order.OrderDao;
import com.revature.mulberry.order.OrderServices;
import com.revature.mulberry.order.OrderServlet;

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
            OrderDao orderDao = new OrderDao();
            CCDao ccDao = new CCDao();

            CustomerServices customerServices = new CustomerServices(customerDao);
            MenuServices menuServices = new MenuServices(menuDao);
            OrderServices orderServices = new OrderServices(orderDao);
            CCServices ccServices = new CCServices(ccDao);

            CustomerServlet customerServlet = new CustomerServlet(customerServices, mapper);
            MenuServlet menuServlet = new MenuServlet(menuServices, mapper);
            OrderServlet orderServlet = new OrderServlet(menuServices, orderServices, mapper);
            CCServlet ccServlet = new CCServlet(mapper, ccServices);
            AdminAuthServlet adminAuthServlet = new AdminAuthServlet(customerServices, mapper);
            CustomerAuthServlet customerAuthServlet = new CustomerAuthServlet(customerServices, mapper);

            ServletContext context = sce.getServletContext();
            context.addServlet("CustomerServlet", customerServlet).addMapping("/customer/*");
            context.addServlet("MenuServlet", menuServlet).addMapping("/menu/*");
            context.addServlet("OrderServlet", orderServlet).addMapping("/order/*");
            context.addServlet("CCServlet", ccServlet).addMapping("/cc/*");
            context.addServlet("AdminAuthServlet", adminAuthServlet).addMapping("/admin/*");
            context.addServlet("CustomerAuthServlet", customerAuthServlet).addMapping("/login/*");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {

            ServletContextListener.super.contextDestroyed(sce);

        }
}

