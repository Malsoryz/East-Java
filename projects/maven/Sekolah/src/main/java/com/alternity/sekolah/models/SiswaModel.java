/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.models;

import com.alternity.sekolah.utils.SQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aru
 */
public class SiswaModel {
    private static Connection conn;
    
    public static List<Siswa> getAll() throws SQLException {
        conn = (Connection) SQLConnection.ConnectDB();
        List<Siswa> result = new ArrayList<>();
        String query = "SELECT * FROM siswa ORDER BY nis ASC;";
        ResultSet set = conn.createStatement().executeQuery(query);
        while (set.next()) {
            Integer getNis = set.getInt("nis");
            String getNama = set.getString("nama");
            String getJK = set.getString("jenis_kelamin");
            String getKelas = set.getString("kelas");
            String getJurusan = set.getString("jurusan");
            String getAlamat = set.getString("alamat");
            result.add(new Siswa(getNis, getNama, getJK, getKelas, getJurusan, getAlamat));
        }
        return result;
    }
    
    public static List<Siswa> getRowWhere(String whereArg) throws SQLException {
        conn = (Connection) SQLConnection.ConnectDB();
        List<Siswa> result = new ArrayList<>();
        String query = String.format("SELECT * FROM siswa WHERE nis = %s ORDER BY nis ASC;", whereArg);
        ResultSet set = conn.createStatement().executeQuery(query);
        while (set.next()) {            
            Integer getNis = set.getInt("nis");
            String getNama = set.getString("nama");
            String getJK = set.getString("jenis_kelamin");
            String getKelas = set.getString("kelas");
            String getJurusan = set.getString("jurusan");
            String getAlamat = set.getString("alamat");
            result.add(new Siswa(getNis, getNama, getJK, getKelas, getJurusan, getAlamat));
        }
        return result;
    }
    
}
