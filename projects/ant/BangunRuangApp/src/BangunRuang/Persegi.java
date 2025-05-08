/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangunRuang;

/**
 *
 * @author malsoryz
 */
public class Persegi {
    private double luas, keliling;
    
    public double getLuas() {
        return luas;
    }
    
    public void setLuas(double sisi) {
        this.luas = sisi * sisi;
    }
    
    public double getKeliling() {
        return keliling;
    }
    
    public void setKeliling(double sisi) {
        this.keliling = 4 * sisi;
    }
}
