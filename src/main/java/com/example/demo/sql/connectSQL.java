package com.example.demo.sql;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class connectSQL {

    private static Connection conn;

    public static Connection get()  throws SQLException {

        if(conn == null){
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-DQ2QBS4\\SQLEXPRESS;databaseName=test;integratedSecurity=true;");
        }
        return conn;
    }
}
