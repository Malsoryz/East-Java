/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.controllers;

import com.alternity.sekolah.models.SiswaTableModel;
import com.alternity.sekolah.views.SiswaView;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author aru
 */
public class SiswaController {
    
    private SiswaTableModel tableModel = new SiswaTableModel();
    
    public static String[] kelasList = new String[]{"X", "XI", "XII"};
    public static String[] jurusanList = new String[]{
        "Rekayasa Perangkat Lunak", 
        "Tata Boga", 
        "Tata Busana", 
        "Kesenian", 
        "Usaha Perjalanan Wisata", 
        "Akomodasi Perhotelan",
        "Tata Kecantikan"
    };
    public static String[] kategoriPencarianList = new String[]{
        "NIS", "Nama", "Jenis Kelamin", "Jurusan", "Kelas", "Alamat"
    };
    
    public SiswaController() {
        SiswaView.tableSiswa.setModel(tableModel);
        SiswaView.fieldNis.setText("");
        SiswaView.fieldNama.setText("");
        SiswaView.radioLakiLaki.setSelected(true);
        SiswaView.radioPerempuan.setSelected(false);
        SiswaView.comboBoxKelas.setModel(new DefaultComboBoxModel<>(kelasList));
        SiswaView.comboBoxJurusan.setModel(new DefaultComboBoxModel<>(jurusanList));
        SiswaView.comboBoxPencarianKategori.setModel(new DefaultComboBoxModel<>(kategoriPencarianList));
        SiswaView.fieldPencarian.setText("");
        
        SiswaView.buttonSimpan.addActionListener(s -> actionSave());
    }
    
    private void actionSave() {
        String getNis = SiswaView.fieldNis.getText().toString();
        String getNama = SiswaView.fieldNama.getName().toString();
        String getJenisKelamin;
        if (SiswaView.radioLakiLaki.isSelected()) getJenisKelamin = "L";
        else if (SiswaView.radioPerempuan.isSelected()) getJenisKelamin = "P";
        String getKelas = SiswaView.comboBoxKelas.getSelectedItem().toString();
        String getJurusan = SiswaView.comboBoxJurusan.getSelectedItem().toString();
        String getAlamat = SiswaView.textAreaAlamat.getText().toString();
    }
    
}
