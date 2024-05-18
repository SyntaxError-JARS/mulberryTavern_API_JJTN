package com.revature.mulberry.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mulberry.auth.Authable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.revature.mulberry.auth.Authable.checkAuthAdmin;

public class MenuServlet extends HttpServlet implements Authable {

    private final MenuServices menuServices;
    private final ObjectMapper mapper;

    public MenuServlet(MenuServices menuServices, ObjectMapper mapper) {
        this.menuServices = menuServices;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        List<Menu> items = menuServices.readAll();
        String payload = mapper.writeValueAsString(items);

        resp.getWriter().write(payload);

    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        if(!checkAuthAdmin(req, resp)) return;

        Menu itemUpdate = mapper.readValue(req.getInputStream(), Menu.class);
        Menu updatedItem = menuServices.update(itemUpdate);


        String payload = mapper.writeValueAsString(updatedItem);
        resp.getWriter().write(payload);

    }
}
