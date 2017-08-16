package com.sparcsky.ems.login;

import com.sparcsky.ems.Employee;
import com.sparcsky.ems.EmployeeDao;
import com.sparcsky.ems.utils.Debug;

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

        Debug.getInstance().init(response.getWriter());
        response.setContentType("text/html");

        String email = request.getParameter("email-login");
        String password = request.getParameter("password-login");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.find(email, password);

        if (employee != null) {
            request.getRequestDispatcher("page/homepage.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("page/login.jsp").forward(request, response);
        }
    }
}
