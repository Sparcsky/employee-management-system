package com.sparcsky.ems.controller;

import com.sparcsky.ems.action.Service;
import com.sparcsky.ems.action.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(value = "/login", name = "LoginControl")

public class LoginControl extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        Service login = ServiceFactory.getAction(request);
        String view = login.execute(request, response);

        if (!view.equals(request.getServletPath())) {
            request.getRequestDispatcher(view + ".jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + view + ".jsp");
        }
    }
}
