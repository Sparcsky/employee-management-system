package com.sparcsky.ems.action;

import com.sparcsky.ems.model.EmployeeDao;
import com.sparcsky.ems.Validate;
import com.sparcsky.ems.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpService implements Service {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email-sign-up");
        String password = request.getParameter("password-sign-up");
        String rptPassword = request.getParameter("password-repeat-sign-up");

        Validate vldPassword = new Validate();

        if (vldPassword.isValid(password, rptPassword)) {
            Employee employee = new Employee();
            employee.setEmail(email);
            employee.setPassword(password);

            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.insert(employee);
        }
        return "/login";
    }
}
