/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author aru
 */
public class SQLConnection {
    private static Connection mysql;
    
    public static Connection ConnectDB() throws SQLException {
        if (mysql == null) try {
            String url = "jdbc:mysql://localhost:3306/mvc_sekolah";
            String user = "root";
            String pass = "alternity351";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysql = (Connection) DriverManager.getConnection(url,user,pass);
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed");
        }
        return mysql;
    }
}
