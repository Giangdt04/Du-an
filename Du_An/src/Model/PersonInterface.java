/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Help.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface PersonInterface {
    public  Integer add(PersonModel ps);
    public  Integer update(PersonModel ps);
    public Integer delete(String ID);
}
