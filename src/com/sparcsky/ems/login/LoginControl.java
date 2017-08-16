package com.sparcsky.ems.login;

import com.sparcsky.ems.Service;
import com.sparcsky.ems.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")

public class LoginControl extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        Service login = ServiceFactory.getAction(request);
        String view = login.execute(request, response);

        if (!view.equals(request.getServletPath())) {
            request.getRequestDispatcher(view + ".jsp").forward(request, response);
        } else {
            response.sendRedirect(view + ".jsp");
        }
    }
}
