package com.sparcsky.ems.action;

import com.sparcsky.ems.model.Employee;
import com.sparcsky.ems.model.EmployeeDao;
import com.sparcsky.ems.model.PersonInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeService implements Service {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PersonInfo personInfo = new PersonInfo();
        personInfo.setFirstName(request.getParameter("first-name"));
        personInfo.setLastName(request.getParameter("last-name"));
        personInfo.setMiddleName(request.getParameter("M.I"));
        personInfo.setAddress(request.getParameter("address"));
        personInfo.setDate(request.getParameter("birth-date"));
        personInfo.setBirthPlace(request.getParameter("birth-place"));
        personInfo.setFirstName(request.getParameter("first-name"));
        personInfo.setGender(request.getParameter("gender"));
        personInfo.setMaritalStatus(request.getParameter("marital-status"));
        personInfo.setPhoneNumber(request.getParameter("phone-number"));

        Employee employee = new Employee();
        employee.setEmail(request.getParameter("email-address"));
        employee.setPersonalInfo(personInfo);

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.insert(employee);

        return "/login";
    }
}
