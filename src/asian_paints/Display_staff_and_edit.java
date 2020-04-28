/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asian_paints;



/**
 *
 * @author Lavanjan
 */
public class Display_staff_and_edit {
    
    private int empid;
    String firstname, lastname, username,password,address,number,gender,roll;
    
    public Display_staff_and_edit(int Empid, String Firstname,String Lastname,String Username,String Password,String Address,String Number,String Gender,String Roll)
    {
      this.empid = Empid;
      this.firstname = Firstname;
      this.lastname = Lastname;
      this.username = Username;
      this.password = Password;
      this.address = Address;
      this.number = Number;
      this.gender =Gender;
      this.roll = Roll;
    }
    
    public int getID()
    {
        return empid;
    }
    
    public String getfname()
    {
        return firstname;
    }
    
    public String getlname()
    {
        return lastname;
    }
    
    public String getuname()
    {
        return username;
    }
    
    public String getpass()
    {
        return password;
    }
    
    public String getAddr()
    {
        return address;
    }
    public String getnum()
    {
        return number;
    }
    
    public String getgen()
    {
        return gender;
    }
    
    public String getroll()
    {
        return roll;
    }
    
    
    
    
}
