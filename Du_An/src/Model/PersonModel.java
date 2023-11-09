/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public abstract class PersonModel {
    protected String ID;
    protected String ma;
    protected String hoTen;
    protected String lop;
    protected String mon;
    protected String email;
    protected String SDT;
    protected boolean gioiTinh;
    protected String diaChi;
    protected String hinh;

    public PersonModel() {
    }

    public PersonModel(String ID, String ma, String hoTen, String lop, String mon, String email, String SDT, boolean gioiTinh, String diaChi, String hinh) {
        this.ID = ID;
        this.ma = ma;
        this.hoTen = hoTen;
        this.lop = lop;
        this.mon = mon;
        this.email = email;
        this.SDT = SDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinh = hinh;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    
}
