/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.models;

import com.alternity.sekolah.utils.SQLConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author aru
 */
public class SiswaModel {
    private static Connection mysql;
    
    public static void add() throws SQLException {
        mysql = (Connection) SQLConnection.ConnectDB();
    }
    
}
