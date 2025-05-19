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
    
    public SiswaModel() throws SQLException {
        this.conn = (Connection) SQLConnection.ConnectDB();
    }
    
    public static List<Siswa> getAll() throws SQLException {
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
    
    public static List<Siswa> getRowLike(String param, String keyword) throws SQLException {
        List<Siswa> result = new ArrayList<>();
        String query = String.format("SELECT * FROM siswa WHERE %s LIKE '%%%s%%' ORDER BY nis ASC;", param, keyword);
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
    
    public static void insertRow(Siswa siswa) throws SQLException {
        Integer getNis = siswa.getNis();
        String getNama = siswa.getNama();
        String getJK = siswa.getJenisKelamin();
        String getKelas = siswa.getKelas();
        String getJurusan = siswa.getJurusan();
        String getAlamat = siswa.getAlamat();
        String query = String.format("INSERT INTO siswa VALUES (%s,'%s','%s','%s','%s','%s');", 
                getNis, getNama, getJK, getKelas, getJurusan, getAlamat);
        conn.prepareStatement(query).execute();
    }
    
    public static void updateRow(Siswa siswa) throws SQLException {
        Integer getNis = siswa.getNis();
        String getNama = siswa.getNama();
        String getJK = siswa.getJenisKelamin();
        String getKelas = siswa.getKelas();
        String getJurusan = siswa.getJurusan();
        String getAlamat = siswa.getAlamat();
        String query = String.format(
                "UPDATE siswa SET nama = '%s', jenis_kelamin = '%s', kelas = '%s', jurusan = '%s', alamat = '%s' WHERE nis = %s;",
                getNama, getJK, getKelas, getJurusan, getAlamat, getNis);
        conn.prepareStatement(query).execute();
    }
    
    public static void deleteRow(Integer nis) throws SQLException {
        String query = String.format("DELETE FROM siswa WHERE nis = %s;", nis);
        conn.prepareStatement(query).execute();
    }
}
