/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alternity.sekolah.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aru
 */
public class SiswaTableModel extends AbstractTableModel {
    
    private List<Siswa> list = new ArrayList<>();
    
    private enum SiswaColumn {
        NO, NIS, NAMA, JK, JURUSAN, KELAS, ALAMAT;
        
        public static SiswaColumn fromIndex(int index) {
            return values()[index];
        }
        
        public static int count() {
            return values().length;
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return SiswaColumn.count();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Siswa siswa = list.get(rowIndex);
        return switch (SiswaColumn.fromIndex(columnIndex)) {
            case NIS -> siswa.getNis();
            case NAMA -> siswa.getNama();
            case JK -> siswa.getJenisKelamin();
            case JURUSAN -> siswa.getJurusan();
            case KELAS -> siswa.getKelas();
            case ALAMAT -> siswa.getAlamat();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (SiswaColumn.fromIndex(column)) {
            case NO -> "No";
            case NIS -> "NIS";
            case NAMA -> "Nama";
            case JK -> "Jenis Kelamin";
            case JURUSAN -> "Jurusan";
            case KELAS -> "Kelas";
            case ALAMAT -> "Alamat";
            default -> null;
        };
    }
    
    
    
    public void insert(Siswa siswa) {
        list.add(siswa);
        fireTableDataChanged();
    }
    
    public void update(int row, Siswa siswa) {
        list.set(row, siswa);
        fireTableDataChanged();
    }
    
    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }
    
    public Siswa get(int row) {
        return list.get(row);
    }
    
    public void setList(List<Siswa> list) {
        this.list = list;
        fireTableDataChanged();
    }

    
}
