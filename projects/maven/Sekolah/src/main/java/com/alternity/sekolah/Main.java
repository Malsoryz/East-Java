/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alternity.sekolah;

import com.alternity.sekolah.controllers.SiswaController;
import com.alternity.sekolah.models.SiswaModel;
import com.alternity.sekolah.views.MainView;
import com.alternity.sekolah.views.SiswaView;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author aru
 */
public class Main {
    
    public static Connection mysql;

    public static void main(String[] args) throws SQLException {
        MainView homeView = new MainView();
        SiswaView siswaView = new SiswaView();
        siswaView.setVisible(true);
        new SiswaModel();
        new SiswaController();
    }
}
