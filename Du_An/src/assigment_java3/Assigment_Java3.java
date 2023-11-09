/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Application;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author Dell
 */
public class Assigment_Java3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userName = "sa";
        String passWord = "123";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DAOTAO";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn;
            
        }catch(Exception e){
            System.out.println("Gặp lỗi:"+e);
        }
    }
    
}
