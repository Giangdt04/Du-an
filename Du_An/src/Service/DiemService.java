/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Help.DBContext;
import Model.IDStudent;
import Model.Diem;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.UUID;

/**
 *
 * @author Dell
 */
public class DiemService {
    public ArrayList<Diem> getAllDiem(){
        ArrayList<Diem> list = new ArrayList<>();
        String sql = "SELECT GRADE.ID,STUDENTS.IDSTUDENT ,STUDENTS.MASV, STUDENTS.HOTEN,STUDENTS.GIOITINH, TINHOC, TIENGANH, GDTC, (TINHOC + TIENGANH + GDTC) / 3.0 AS 'DIEMTB' FROM GRADE ,STUDENTS\n"
                + "WHERE GRADE.IDSTUDENT = STUDENTS.IDSTUDENT";
        Connection cn = DBContext.getConnection();
        
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
               
                IDStudent id = new IDStudent();
                id.setIdStudent(rs.getString("IDSTUDENT"));
                
                Diem diem = new Diem();
                diem.setID(rs.getString("ID"));
                diem.setIDStudent(id);
                diem.setMaSV(rs.getString("MASV"));
                diem.setHoTen(rs.getString("HOTEN"));
                diem.setGioiTinh(rs.getString("GIOITINH"));
                diem.setTiengAnh(rs.getInt("TIENGANH"));
                diem.setTinHoc(rs.getInt("TINHOC"));
                diem.setGDTC(rs.getInt("GDTC"));
                list.add(diem);
            }
        } catch (SQLException ex) {
            System.out.println("loi:" +ex);
        }
        return list; 
    }
    public ArrayList<Diem> searchSinhVien(String maSearch , String hoTen, boolean gioiTinh){
        ArrayList<Diem> search = new ArrayList<>();
        String sql = "SELECT GRADE.ID,STUDENTS.IDSTUDENT ,STUDENTS.MASV, STUDENTS.HOTEN, TINHOC, TIENGANH, GDTC, (TINHOC + TIENGANH + GDTC) / 3.0 AS 'DIEMTB' FROM GRADE JOIN STUDENTS\n"
                + "ON GRADE.IDSTUDENT = STUDENTS.IDSTUDENT\n"
                + "WHERE STUDENTS.MASV = ? OR STUDENTS.HOTEN like '%"+hoTen+"%' AND STUDENTS.GIOITINH = ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setString(1, maSearch);
            pstm.setBoolean(2, gioiTinh);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Diem diem = new Diem();
                IDStudent id = new IDStudent();
                id.setIdStudent(rs.getString("IDSTUDENT"));
                
                diem.setID(rs.getString("ID"));
                diem.setIDStudent(id);
                diem.setMaSV(rs.getString("MASV"));
                diem.setHoTen(rs.getString("HOTEN"));
                diem.setTiengAnh(rs.getInt("TIENGANH"));
                diem.setTinHoc(rs.getInt("TINHOC"));
                diem.setGDTC(rs.getInt("GDTC"));
                search.add(diem);
            }
        } catch (SQLException ex) {
            System.out.println("Loi search:" +ex);
        
        }
        return search;
    }
    public Integer addDiem(Diem diem){
        Integer row = null;
        String sql;
        sql = "INSERT INTO GRADE(IDSTUDENT,TIENGANH,TINHOC,GDTC)\n"
                +"VALUES(?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, diem.getIDStudent().getIdStudent());
            pstm.setInt(2, diem.getTiengAnh());
            pstm.setInt(3, diem.getTinHoc());
            pstm.setInt(4, diem.getGDTC());
            
            row = pstm.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return row;
    }
    public Integer updateDiem(Diem diem){
        Integer row = null;
        String sql = "UPDATE GRADE\n"
                    + "SET TIENGANH = ?, TINHOC= ?, GDTC = ?\n"
                    +"WHERE IDSTUDENT = ?";
        Connection cn = DBContext.getConnection();
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(4, diem.getIDStudent().getIdStudent());
            pstm.setInt(1, diem.getTiengAnh());
            pstm.setInt(2, diem.getTinHoc());
            pstm.setInt(3, diem.getGDTC());
            
            row = pstm.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return row;
    }
    public Integer deleteDiem(String idSTUDENT){
        Integer row = null;
        String sql = "DELETE FROM GRADE\n"
                    + "WHERE IDSTUDENT = ?";
        Connection cn = DBContext.getConnection();
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, idSTUDENT);
            row = pstm.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return row;
    }
    public ArrayList<IDStudent> getComboBox() {
        ArrayList<IDStudent> lst = new ArrayList<>();
        try {
            String sql = "select STUDENTS.IDSTUDENT, STUDENTS.MASV, STUDENTS.HOTEN from  GRADE RIGHT JOIN STUDENTS\n"
                        + "ON GRADE.IDSTUDENT = STUDENTS.IDSTUDENT";
            //tạo kết nối
            Connection cn = DBContext.getConnection();
            //tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //thi hành statement
            ResultSet rs = pstm.executeQuery();
            //Duyệt ra => lấy dữ liệu đổ vào list
            while (rs.next()) {
                IDStudent n = new IDStudent();
                n.setMaSV(rs.getString("MASV"));
                n.setHoTen(rs.getString("HOTEN"));
                n.setIdStudent(rs.getString("IDSTUDENT"));
                lst.add(n);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
}

