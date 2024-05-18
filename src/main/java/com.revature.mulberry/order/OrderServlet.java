package com.revature.mulberry.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mulberry.auth.Authable;
import com.revature.mulberry.customer.Customer;
import com.revature.mulberry.menu.Menu;
import com.revature.mulberry.menu.MenuServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.revature.mulberry.auth.Authable.checkAuthCustomer;

public class OrderServlet extends HttpServlet implements Authable {

    private final MenuServices menuServices;
    private final OrderServices orderServices;
    private final ObjectMapper mapper;

    public OrderServlet(MenuServices menuServices, OrderServices orderServices, ObjectMapper mapper) {
        this.menuServices = menuServices;
        this.orderServices = orderServices;
        this.mapper = mapper;
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
        Orders newOrder = new Orders();
        OrderInitializer initOrder = mapper.readValue(req.getInputStream(), OrderInitializer.class); // from JSON to Java Object (Pokemon)
        try{
            Menu item = menuServices.readById(String.valueOf(initOrder.getMenu_item()));
            newOrder.setMenu_item(item);
            newOrder.setComment(initOrder.getComment());
            newOrder.setIs_favorite(initOrder.isIs_favorite());
            newOrder.setOrder_date(initOrder.getOrder_date());
            newOrder.setCustomer_username(authCustomer);

        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }


        Orders persistedOrder = orderServices.create(newOrder);

        // String payload = mapper.writeValueAsString(newOrder); // Mapping from Java Object (Pokemon) to JSON

        resp.getWriter().write("Got your order. Your order id is: \n");
        resp.getWriter().write(persistedOrder.idToString());
        resp.setStatus(201);
    }
}
