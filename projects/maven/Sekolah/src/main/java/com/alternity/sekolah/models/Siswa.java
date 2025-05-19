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
    private String kelas;
    private String jurusan;
    private String alamat;
    
    private final int totalObject = 6;

    public Siswa(Integer nis, String nama, String jenisKelamin, String kelas, String jurusan, String alamat) {
        this.nis = nis;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.kelas = kelas;
        this.jurusan = jurusan;
        this.alamat = alamat;
    }

    public Integer getNis() {
        return nis;
    }

    public void setNis(Integer nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
