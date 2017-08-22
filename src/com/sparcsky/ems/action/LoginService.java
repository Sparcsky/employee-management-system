package com.sparcsky.ems.action;

import com.sparcsky.ems.model.Employee;
import com.sparcsky.ems.model.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginService implements Service {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email-login");
        String password = request.getParameter("password-login");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.find(email, password);

        employeeDao.open();

        List<Employee> employees = employeeDao.getList();

        if (employee != null) {
            request.setAttribute("employees", employees);
            request.setAttribute("email", employee.getEmail());
            request.setAttribute("email",employees.get(0).getFirstName());
            request.getSession().setAttribute("email", employee.getEmail());
            return "/home";
        }
        return "/login";
    }
}
