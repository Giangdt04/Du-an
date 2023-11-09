/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Help.DBContext;
import Model.User;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class LoginService {

    public String checkLogin(String un, String pass) {
        String vaitro = "";
        try {
            Connection cn = DBContext.getConnection();
            String sql = "SELECT * FROM USERS\n"
                    + "	WHERE USERNAME =? AND PASSWORD =?";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, un);
            pstm.setString(2, pass);

//            row = pstm.executeUpdate(); update chi dung cho ichert,dele,update
            ResultSet rs = pstm.executeQuery();
//            rs.next();

            while (rs.next()) {

                vaitro = rs.getString("ROLE");

            }
        } catch (SQLException ex) {
            System.out.println("Loi checkLogin: " + ex.getMessage());
        }
        return vaitro;
    }
}
