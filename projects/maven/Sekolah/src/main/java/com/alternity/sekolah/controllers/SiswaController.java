/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.controllers;

import com.alternity.sekolah.models.Siswa;
import com.alternity.sekolah.models.SiswaModel;
import com.alternity.sekolah.models.SiswaTableModel;
import com.alternity.sekolah.views.SiswaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

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
        "NIS", "Nama", "Jenis Kelamin", "Kelas", "Jurusan", "Alamat"
    };
    
    public SiswaController() throws SQLException {
        SiswaView.tableSiswa.setModel(tableModel);
        refreshTable(SiswaModel.getAll());
        
        SiswaView.comboBoxKelas.setModel(new DefaultComboBoxModel<>(kelasList));
        SiswaView.comboBoxJurusan.setModel(new DefaultComboBoxModel<>(jurusanList));
        SiswaView.comboBoxPencarianKategori.setModel(new DefaultComboBoxModel<>(kategoriPencarianList));
        resetForm(true);
        
        // Listener
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
        SiswaView.buttonSimpan.addActionListener((ActionEvent e) -> {
            try {
                actionSave();
                refreshTable(SiswaModel.getAll());
            } catch (SQLException ex) {
                Logger.getLogger(SiswaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        SiswaView.buttonBatal.addActionListener(e -> {
            resetForm(false);
        });
        SiswaView.buttonTambah.addActionListener(e -> {
            resetForm(false);
        });
        SiswaView.buttonUbah.addActionListener(e -> {
            try {
                actionChange();
                refreshTable(SiswaModel.getAll());
            } catch (SQLException ex) {
                Logger.getLogger(SiswaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        SiswaView.buttonHapus.addActionListener(e -> {
            try {
                actionDelete();
                refreshTable(SiswaModel.getAll());
                resetForm(false);
            } catch (SQLException ex) {
                Logger.getLogger(SiswaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        SiswaView.buttonSegarkan.addActionListener(e -> {
            try {
                refreshTable(SiswaModel.getAll());
                resetForm(true);
            } catch (SQLException ex) {
                Logger.getLogger(SiswaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        SiswaView.buttonPencarian.addActionListener(e -> {
            try {
                actionSearch();
            } catch (SQLException ex) {
                Logger.getLogger(SiswaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        SiswaView.buttonKeluar.addActionListener(e -> {
            System.exit(0);
        });
    }
    
    private void refreshTable(List<Siswa> data) throws SQLException {
        while (tableModel.getRowCount() > 0) {            
            tableModel.delete(0);
        }
        List<Siswa> modelData = data;
        for (Siswa siswa: modelData) {
            tableModel.insert(siswa);
        }
    }
    
    private void resetForm(boolean isResetPencarian) {
        SiswaView.fieldNis.setText("");
        SiswaView.fieldNama.setText("");
        SiswaView.radioLakiLaki.setSelected(true);
        SiswaView.radioPerempuan.setSelected(false);
        SiswaView.comboBoxKelas.setSelectedIndex(0);
        SiswaView.comboBoxJurusan.setSelectedIndex(0);
        SiswaView.textAreaAlamat.setText("");
        if (isResetPencarian) {
            SiswaView.comboBoxPencarianKategori.setSelectedIndex(0);
            SiswaView.fieldPencarian.setText("");
        }
    }
    
    private void actionGetRowFromTable() throws SQLException {
        String getSelectedRow = tableModel.getValueAt(SiswaView.tableSiswa.getSelectedRow(), 1).toString();
        List<Siswa> modelData = SiswaModel.getRowWhere(getSelectedRow);
        for (Siswa siswa: modelData) {
            SiswaView.fieldNis.setText(String.valueOf(siswa.getNis()));
            SiswaView.fieldNama.setText(siswa.getNama());
            SiswaView.radioLakiLaki.setSelected("L".equals(siswa.getJenisKelamin()));
            SiswaView.radioPerempuan.setSelected("P".equals(siswa.getJenisKelamin()));
            SiswaView.comboBoxKelas.setSelectedItem(siswa.getKelas());
            SiswaView.comboBoxJurusan.setSelectedItem(siswa.getKelas());
            SiswaView.textAreaAlamat.setText(siswa.getAlamat());
        }
    }
    
    private void actionSearch() throws SQLException {
        String getCategory = SiswaView.comboBoxPencarianKategori.getSelectedItem().toString();
        String getKeyword = "";
        if (getCategory.equals("Jenis Kelamin")) {
            if (null == SiswaView.fieldPencarian.getText()) {
            } else switch (SiswaView.fieldPencarian.getText()) {
                case "Laki-Laki" -> getKeyword = "L";
                case "laki-laki" -> getKeyword = "L";
                case "Laki Laki" -> getKeyword = "L";
                case "laki laki" -> getKeyword = "L";
                case "Laki" -> getKeyword = "L";
                case "laki" -> getKeyword = "L";
                case "L" -> getKeyword = "L";
                case "l" -> getKeyword = "L";
                case "Perempuan" -> getKeyword = "P";
                case "perempuan" -> getKeyword = "P";
                case "Perem" -> getKeyword = "P";
                case "perem" -> getKeyword = "P";
                case "Puan" -> getKeyword = "P";
                case "puan" -> getKeyword = "P";
                case "P" -> getKeyword = "P";
                case "p" -> getKeyword = "P";
                default -> getKeyword = "Nope";
            }
        } else getKeyword = SiswaView.fieldPencarian.getText();
        String parameter = "";
        switch (getCategory) {
            case "NIS" -> parameter = "nis";
            case "Nama" -> parameter = "nama";
            case "Jenis Kelamin" -> parameter = "jenis_kelamin";
            case "Kelas" -> parameter = "kelas";
            case "Alamat" -> parameter = "alamat";
            default -> parameter = "";
        }
        SiswaModel.getRowLike(parameter, getKeyword);
        refreshTable(SiswaModel.getRowLike(parameter, getKeyword));
    }
    
    private void actionSave() throws SQLException {
        Integer getNis = Integer.valueOf(SiswaView.fieldNis.getText());
        String getNama = SiswaView.fieldNama.getText();
        String getJenisKelamin = "";
        if (SiswaView.radioLakiLaki.isSelected()) getJenisKelamin = "L";
        else if (SiswaView.radioPerempuan.isSelected()) getJenisKelamin = "P";
        String getKelas = SiswaView.comboBoxKelas.getSelectedItem().toString();
        String getJurusan = SiswaView.comboBoxJurusan.getSelectedItem().toString();
        String getAlamat = SiswaView.textAreaAlamat.getText();
        Siswa siswa = new Siswa(getNis, getNama, getJenisKelamin, getKelas, getJurusan, getAlamat);
        SiswaModel.insertRow(siswa);
    }
    
    private void actionChange() throws SQLException {
        Integer getNis = Integer.valueOf(SiswaView.fieldNis.getText());
        String getNama = SiswaView.fieldNama.getText();
        String getJenisKelamin = "";
        if (SiswaView.radioLakiLaki.isSelected()) getJenisKelamin = "L";
        else if (SiswaView.radioPerempuan.isSelected()) getJenisKelamin = "P";
        String getKelas = SiswaView.comboBoxKelas.getSelectedItem().toString();
        String getJurusan = SiswaView.comboBoxJurusan.getSelectedItem().toString();
        String getAlamat = SiswaView.textAreaAlamat.getText();
        Siswa siswa = new Siswa(getNis, getNama, getJenisKelamin, getKelas, getJurusan, getAlamat);
        SiswaModel.updateRow(siswa);
    }
    
    private void actionDelete() throws SQLException {
        String getNis = SiswaView.fieldNis.getText();
        if (!(getNis.isEmpty() || getNis.isBlank())) {
            SiswaModel.deleteRow(Integer.valueOf(getNis));
        } else JOptionPane.showMessageDialog(null, "NIS tidak boleh kosong untuk menghapus baris");
    }
}
