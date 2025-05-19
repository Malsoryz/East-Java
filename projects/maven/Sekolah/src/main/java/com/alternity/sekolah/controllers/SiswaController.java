/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.controllers;

import com.alternity.sekolah.models.Siswa;
import com.alternity.sekolah.models.SiswaModel;
import com.alternity.sekolah.models.SiswaTableModel;
import com.alternity.sekolah.views.SiswaView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public SiswaController() throws SQLException {
        SiswaView.tableSiswa.setModel(tableModel);
        List<Siswa> modelData = SiswaModel.getAll();
        for (Siswa siswa: modelData) {
            tableModel.insert(siswa);
        }
        
        SiswaView.fieldNis.setText("");
        SiswaView.fieldNama.setText("");
        SiswaView.radioLakiLaki.setSelected(true);
        SiswaView.radioPerempuan.setSelected(false);
        SiswaView.comboBoxKelas.setModel(new DefaultComboBoxModel<>(kelasList));
        SiswaView.comboBoxJurusan.setModel(new DefaultComboBoxModel<>(jurusanList));
        SiswaView.textAreaAlamat.setText("");
        SiswaView.comboBoxPencarianKategori.setModel(new DefaultComboBoxModel<>(kategoriPencarianList));
        SiswaView.fieldPencarian.setText("");
        
        SiswaView.tableSiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    actionGetRowFromTable();
                } catch (SQLException ex) {
                    Logger.getLogger(SiswaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        SiswaView.buttonSimpan.addActionListener(s -> actionSave());
    }
    
    private void actionGetRowFromTable() throws SQLException {
        String getSelectedRow = tableModel.getValueAt(SiswaView.tableSiswa.getSelectedRow(), 1).toString();
        List<Siswa> modelData = SiswaModel.getRowWhere(getSelectedRow);
        for (Siswa siswa: modelData) {
            SiswaView.fieldNis.setText(String.valueOf(siswa.getNis()));
            SiswaView.fieldNama.setText(siswa.getNama());
            SiswaView.radioLakiLaki.setSelected("L".equals(siswa.getJenisKelamin()) ? true : false);
            SiswaView.radioPerempuan.setSelected("P".equals(siswa.getJenisKelamin()) ? true : false);
            SiswaView.comboBoxKelas.setSelectedItem(siswa.getKelas());
            SiswaView.comboBoxJurusan.setSelectedItem(siswa.getKelas());
            SiswaView.textAreaAlamat.setText(siswa.getAlamat());
        }
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
