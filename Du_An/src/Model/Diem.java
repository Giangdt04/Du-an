/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Dell
 */
public class Diem {
    private String maSV;
    private String ID;
    private String hoTen;
    private String gioiTinh;
    private Integer tiengAnh;
    private Integer tinHoc;
    private Integer GDTC;
    private IDStudent IDStudent;
    private Double diemTB;

    public Diem() {
    }

    public Diem(String maSV, String ID, String hoTen, String gioiTinh, Integer tiengAnh, Integer tinHoc, Integer GDTC, IDStudent IDStudent, Double diemTB) {
        this.maSV = maSV;
        this.ID = ID;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
        this.IDStudent = IDStudent;
        this.diemTB = diemTB;
    }
    

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(Integer tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public Integer getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(Integer tinHoc) {
        this.tinHoc = tinHoc;
    }

    public Integer getGDTC() {
        return GDTC;
    }

    public void setGDTC(Integer GDTC) {
        this.GDTC = GDTC;
    }

    public IDStudent getIDStudent() {
        return IDStudent;
    }

    public void setIDStudent(IDStudent IDStudent) {
        this.IDStudent = IDStudent;
    }

    

      public BigDecimal getDiemTB() {
        diemTB = (this.tiengAnh + this.tinHoc + this.getGDTC()) / 3.0;
        BigDecimal dtb = new BigDecimal(diemTB);
        BigDecimal rounded = dtb
                .round(new MathContext(3, RoundingMode.HALF_EVEN));
        return rounded;
    }

    
    
}
