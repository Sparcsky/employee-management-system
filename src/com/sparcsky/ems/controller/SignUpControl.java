package com.sparcsky.ems.controller;

import com.sparcsky.ems.action.Service;
import com.sparcsky.ems.action.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register", name = "SignUpControl")
public class SignUpControl extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Service service = ServiceFactory.getAction(request);
        String view = service.execute(request, response);

        request.getRequestDispatcher(view + ".jsp").forward(request, response);

    }
}
