package com.sparcsky.ems.login;

import com.sparcsky.ems.EmployeeDao;
import com.sparcsky.ems.Service;
import com.sparcsky.ems.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginService implements Service {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email-login");
        String password = request.getParameter("password-login");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.find(email, password);

        if (employee != null) {
            request.getSession().setAttribute("employee", employee);
            return "/home";
        }

        return "/login";
    }
}
