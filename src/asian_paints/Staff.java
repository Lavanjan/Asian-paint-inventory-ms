/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asian_paints;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lavanjan
 */
public class Staff {
    
    public void update_delete_staff(char operation,Integer EmpID, String firstname, String lastname, String username, String password,String address, String number,String gender, String roll)
    {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if(operation == 'i')
        {
            try {
                ps = con.prepareStatement("INSERT INTO login(firstname, lastname, username, password, address, number, gender, roll) VALUES (?,?,?,?,?,?,?,?");
                ps.setString(1, firstname);
                ps.setString(2, lastname);
                ps.setString(3, username);
                ps.setString(4, password);
                ps.setString(5, address);
                ps.setString(6, number);
                ps.setString(7, gender);
                ps.setString(8, roll);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Staff Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if(operation == 'u')    // Update
        {
            try {
                ps = con.prepareStatement("UPDATE `login` SET `firstname`="+firstname+",`lastname`="+lastname+",`username`="+username+",`password`="+password+",`address`="+address+",`number`="+number+",`gender`="+gender+",`roll`="+roll+" WHERE `EmpID`="+EmpID+"");
                ps.setString(1, firstname);
                ps.setString(2, lastname);
                ps.setString(3, username);
                ps.setString(3, password);
                ps.setString(4, address);
                ps.setString(5, number);
                ps.setString(6, gender);
                ps.setString(7, roll);
              ps.setInt(8, EmpID);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Staff Updated");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        
        
        
    }
    
    public void fillJtable(JTable table, String ValueToSearch){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `login` WHERE CONCAT (`firstname`,`lastname`,`username`,`password`,`address`,`number`,`gender`,`roll`)LIKE ?");
            ps.setString(1,"%"+ValueToSearch+"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            while(rs.next()){
                row = new Object[9];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                
                model.addRow(row);
            }
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
