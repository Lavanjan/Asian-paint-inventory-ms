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
public class sales {
    
    private int salesid, cusid, proid, price, quantity;
    String modelname, color;
    
    public sales(int Cusid, int Salesid, int Proid, String Modelname, String Color, int Price, int Quantity){
        this.cusid = Cusid;
        this.salesid = Salesid;
        this.proid = Proid;
        this.modelname = Modelname;
        this.color = Color;
        this.price = Price;
         this.quantity = Quantity;
        
        
    }
    
    public int getcusID()
    {
        return cusid;
    }
    
    public int getsalesID()
    {
        return salesid;
    }
    
    public int getproID()
    {
        return proid;
    }
    
    
     public String getmodelname()
    {
        return modelname;
    }
     
      public String getcolor()
    {
        return color;
    }
    
    public int getPrice()
    {
        return price;
    }
      
      public int getQty()
    {
        return quantity;
    }
    
    
}
