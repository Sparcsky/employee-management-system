package com.sparcsky.ems;

import com.sparcsky.ems.utils.DButil;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeService {


    public Employee find(String email, String password) {

        Employee employee = new Employee();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("SELECT email_address,password FROM employee WHERE email_address=? AND password=?");
            statement.setString(1, email);
            statement.setString(2, password);
            statement.executeQuery();

            resultSet = statement.getResultSet();
            resultSet.next();

            String resultEmail = resultSet.getString("email_address");
            String resultPassword = resultSet.getString("password");


        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            DButil.close(resultSet, statement, connection);
        }


        return employee;
    }

}
