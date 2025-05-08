/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.models;

/**
 *
 * @author aru
 */
public class Siswa {
    
    private Integer nis;
    private String nama;
    private String jenisKelamin;
    private String jurusan;
    private String kelas;
    private String alamat;

    public Siswa(Integer nis, String nama, String jenisKelamin, String jurusan, String kelas, String alamat) {
        this.nis = nis;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.jurusan = jurusan;
        this.kelas = kelas;
        this.alamat = alamat;
    }

    public Integer getNis() {
        return nis;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getKelas() {
        return kelas;
    }

    public String getAlamat() {
        return alamat;
    }
    
    

}
