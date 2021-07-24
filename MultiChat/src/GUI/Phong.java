/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

/**
 *
 * @author PhamTrongTruong
 */
public class Phong {
    String ID;
    int SoNguoi;
    ArrayList<SinhVien> sinhVien=new ArrayList<>();
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }

    public ArrayList<SinhVien> getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(ArrayList<SinhVien> sinhVien) {
        this.sinhVien = sinhVien;
    }

   
   
    
    
}
