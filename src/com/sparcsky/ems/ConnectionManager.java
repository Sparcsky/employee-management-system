package com.sparcsky.ems;

import com.zaxxer.hikari.HikariDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static HikariDataSource dataSource;

    private static void connectDatabase() {
        try {
            Context initCtx = new InitialContext();
            dataSource = (HikariDataSource) initCtx.lookup("java:comp/env/jdbc/mysqlHikari");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException, NamingException {
        if (dataSource == null) {
            connectDatabase();
        }
        return dataSource.getConnection();
    }

}