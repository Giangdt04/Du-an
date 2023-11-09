/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Help.DBContext;
import Model.GiaoVien;
import Model.PersonInterface;
import Model.PersonModel;
import Model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Dell
 */
public class GiaoVienService implements PersonInterface {
    public ArrayList<PersonModel> getAllGiaoVien(){
        ArrayList<PersonModel> list = new ArrayList<>();
        String sql = "SELECT * FROM TEACHERS";
        //tạo kết nối
        Connection cn = DBContext.getConnection();
        try {
            //tạo kết nối statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //thi hành statement
            ResultSet rs = pstm.executeQuery();
            //Duyệt ra => lấy dữ liệu đổ vào list
            while (rs.next()) {
               PersonModel sv = new PersonModel() {};
               sv.setID(rs.getString("IDTEACHER"));
               sv.setMa(rs.getString("MAGV"));
               sv.setMon(rs.getString("MON"));
               sv.setHoTen(rs.getString("HOTEN"));
               sv.setEmail(rs.getString("EMAIL"));
               sv.setSDT(rs.getString("SDT"));
               sv.setGioiTinh(rs.getBoolean("GIOITINH"));
               sv.setDiaChi(rs.getString("DIACHI"));
               sv.setHinh(rs.getString("HINH"));
               list.add(sv);
            } 
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    } 
   
    @Override
    public Integer delete(String ID) {
        Integer row = null;
        String sql ="Delete from TEACHERS\n"
                    + "WHERE IDTEACHER = ?";
        //tạo kết nối
        Connection cn = DBContext.getConnection();
        try {
            //tạo Statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            pstm.setString(1, ID);
            //thi hành Statement
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row;
    }
   

    @Override
    public Integer add(PersonModel ps) {
        Integer row = null;
        String sql = "INSERT INTO TEACHERS(IDTEACHER,MAGV,MON,HOTEN,EMAIL,SDT,GIOITINH,DIACHI,HINH)"
                    +"VALUES(?,?,?,?,?,?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            String uniqueID = UUID.randomUUID().toString(); 
            pstm.setString(1, uniqueID);
            pstm.setString(2, ps.getMa());
            pstm.setString(3, ps.getMon());
            pstm.setString(4, ps.getHoTen());
            pstm.setString(5, ps.getEmail());
            pstm.setString(6, ps.getSDT());
            pstm.setBoolean(7, ps.isGioiTinh());
            pstm.setString(8, ps.getDiaChi());
            pstm.setString(9, ps.getHinh());
            
            row = pstm.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return row;
    }

    @Override
    public Integer update(PersonModel ps) {
         Integer row = null;
        String sql = "UPDATE TEACHERS\n"
                + "SET MON = ?,HOTEN=?,EMAIL=?,SDT=?,GIOITINH=?,DIACHI=?,HINH=?\n"
                + "WHERE IDTEACHER = ?";
        //Tạo kết nối
        System.out.println("SQL UPDate: "+sql);
        System.out.println("IDTEACHER: " +ps.getID());
        System.out.println("MAGV: " +ps.getMa());
        //check lỗi
        Connection cn = DBContext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            
            pstm.setString(1, ps.getMon());
            pstm.setString(2, ps.getHoTen());
            pstm.setString(3, ps.getEmail());
            pstm.setString(4, ps.getSDT());
            pstm.setBoolean(5, ps.isGioiTinh());
            pstm.setString(6, ps.getDiaChi());
            pstm.setString(7, ps.getHinh());
            pstm.setString(8, ps.getID());
            //thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

   
     
}
