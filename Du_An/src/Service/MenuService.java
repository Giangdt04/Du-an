/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Help.DBContext;
import Model.User;
import View.Menu;
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
public class MenuService {

    public String checkMenu(User us) {
        String vaitro = "";
        try {
            Connection cn = DBContext.getConnection();
            String sql = "SELECT * FROM USERS\n";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                us.setUserName(rs.getString("USERNAME"));
                us.setPass(rs.getString("PASSWORD"));
                vaitro = rs.getString("ROLE");
            }
        } catch (SQLException ex) {
            System.out.println("Loi checkLogin: " + ex.getMessage());
        }
        return vaitro;
    }
}
