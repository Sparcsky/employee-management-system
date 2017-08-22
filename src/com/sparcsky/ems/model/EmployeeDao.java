package com.sparcsky.ems.model;

import com.sparcsky.ems.ConnectionManager;
import com.sparcsky.ems.utils.DButil;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeDao implements BaseDao<Employee> {

    private Map<String, Employee> employees = new HashMap<>();
    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;
    private boolean insert = false;

    public EmployeeDao() {
        try {
            connection = ConnectionManager.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    public void open() {
        try {
            connection = ConnectionManager.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Employee find(final String email, final String password) {
        Employee employee = null;

        if (employees.containsKey(email)) {
            employee = employees.get(email);
            return employee;
        }
        try {
            statement = connection.prepareStatement("SELECT email,password FROM user WHERE email=?");
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String rsEmail = resultSet.getString("email");
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

    public List<Employee> getList() {
        List<Employee> employees = new ArrayList<>();
        try {

            statement = connection.prepareStatement("SELECT * FROM personal_details");
            resultSet = statement.executeQuery();
            System.out.println(resultSet.getMetaData().getColumnCount());

            while (resultSet.next()) {
                Employee employee = new Employee();
                PersonInfo personInfo = new PersonInfo();

                personInfo.setFirstName(resultSet.getString(2));
                personInfo.setLastName(resultSet.getString(3));
                personInfo.setMiddleName(resultSet.getString(4));
                personInfo.setAddress(resultSet.getString(5));
                personInfo.setDate(resultSet.getDate(6).toString());
                personInfo.setBirthPlace(resultSet.getString(7));
                personInfo.setGender(resultSet.getString(8));
                personInfo.setMaritalStatus(resultSet.getString(9));
                personInfo.setPhoneNumber(resultSet.getString(10));

                employee.setPersonalInfo(personInfo);
                employees.add(employee);
            }


        } catch (SQLException e) {
            insert = false;
            e.printStackTrace();
            DButil.close(resultSet, statement, connection);
        }
        return employees;
    }

    @Override
    public void insert(Employee employee) {
        try {
            statement = connection.prepareStatement("INSERT INTO" +
                    " personal_details(" +
                    "first_name, last_name, middle_initial," +
                    " address, birth_date, birth_place, " +
                    "gender, marital_status,phone_number) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)");

            statement.setString(1, employee.getPersonInfo().getFirstName());
            statement.setString(2, employee.getPersonInfo().getLastName());
            statement.setString(3, employee.getPersonInfo().getMiddleName());
            statement.setString(4, employee.getPersonInfo().getAddress());
            statement.setDate(5, employee.getPersonInfo().getBirthDate());
            statement.setString(6, employee.getPersonInfo().getBirthPlace());
            statement.setString(7, employee.getPersonInfo().getGender());
            statement.setString(8, employee.getPersonInfo().getMaritalStatus());
            statement.setString(9, employee.getPersonInfo().getPhoneNumber());
            statement.executeUpdate();

            System.out.println("INSERT SUCCESS");
        } catch (SQLException e) {
            insert = false;
            e.printStackTrace();
        } finally {

            DButil.close(statement, connection);
            insert = true;

        }
    }

    @Override
    public void update(Employee value) {

    }

    public boolean insertSuccess() {
        return insert;
    }

    @Override
    public void delete(Employee value) {

    }

    public int getRowSize() {
        int size = 0;
        try {
            if (!connection.isClosed()) {
                statement = connection.prepareStatement("SELECT COUNT(*) AS ROW_COUNT FROM personal_details");
                resultSet = statement.executeQuery();
                resultSet.next();
                size = resultSet.getInt("ROW_COUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }
}