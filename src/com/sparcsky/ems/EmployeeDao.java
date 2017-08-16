package com.sparcsky.ems;

import com.sparcsky.ems.model.Employee;
import com.sparcsky.ems.utils.DButil;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao implements BaseDao<Employee> {

    private List<Employee> employees = new ArrayList<>();
    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    public EmployeeDao() {
        try {
            connection = ConnectionManager.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Employee find(final String email, final String password) {
        Employee employee = null;
        try {
            statement = connection.prepareStatement("SELECT email_address,password FROM personal_details WHERE email_address=?");
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String rsEmail = resultSet.getString("email_address");
                String rsPassword = resultSet.getString("password");

                if (email.equals(rsEmail) && password.equals(rsPassword)) {
                    employee = new Employee();
                    employee.setEmail(rsEmail);
                    employee.setPassword(rsPassword);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(resultSet, statement, connection);
        }
        return employee;
    }

    @Override
    public List<Employee> find() {
        return null;
    }

    @Override
    public void insert(Employee value) {

    }

    @Override
    public void update(Employee value) {

    }

    @Override
    public void delete(Employee value) {

    }

}