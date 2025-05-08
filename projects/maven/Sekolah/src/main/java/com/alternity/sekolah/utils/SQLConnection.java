/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author aru
 */
public class SQLConnection {
    
    private static Connection mysql;
    private static Driver driver;
    
    private static final String USER = "root";
    private static final String USER_PASS = "alternity351";
    private static final String DATABASE_URL = "localhost:3306/mvc_sekolah";
    
    public static Connection ConnectDB() throws SQLException {
        System.out.println("Start MySQL Connection");
        System.out.println(String.format("User : %s", USER));
        System.out.println(String.format("URL  : %s", DATABASE_URL));
        driver = new Driver();
        if (mysql == null) try {
            String url = String.format("jdbc:mysql://%s", DATABASE_URL);
            DriverManager.registerDriver(driver);
            mysql = (Connection) DriverManager.getConnection(url, USER, USER_PASS);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println(String.format("Error at getConnection, details : %s", e));
            System.exit(0);
        }
        return mysql;
    }
}
