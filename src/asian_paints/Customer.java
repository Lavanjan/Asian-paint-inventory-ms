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
public class Customer {
    private int cusid;
    String firstname, lastname, address,number;
    
    public Customer(int CusId, String Firstname,String Lastname,String Address,String Number)
    {
      this.cusid = CusId;
      this.firstname = Firstname;
      this.lastname = Lastname;
      this.address = Address;
      this.number = Number;
     
    }
    
    public int getID()
    {
        return cusid;
    }
    
    public String getfname()
    {
        return firstname;
    }
    
    public String getlname()
    {
        return lastname;
    }

    public String getAddr()
    {
        return address;
    }
    public String getnum()
    {
        return number;
    }
    
}
