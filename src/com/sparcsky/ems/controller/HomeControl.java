package com.sparcsky.ems.controller;

import com.sparcsky.ems.action.Service;
import com.sparcsky.ems.action.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HomeControl extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Service service = ServiceFactory.getAction(request);
        String view = service.execute(request, response);

        if (view.equals(request.getServletPath())) {
            request.getRequestDispatcher(view + ".jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }
}
