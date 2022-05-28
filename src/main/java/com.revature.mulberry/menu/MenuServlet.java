package com.revature.mulberry.menu;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MenuServlet extends HttpServlet {

    private final MenuServices menuServices;
    private final ObjectMapper mapper;

    public MenuServlet(MenuServices menuServices, ObjectMapper mapper) {
        this.menuServices = menuServices;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Menu> items = menuServices.readAll();
        String payload = mapper.writeValueAsString(items);

        resp.getWriter().write(payload);

    }
}
