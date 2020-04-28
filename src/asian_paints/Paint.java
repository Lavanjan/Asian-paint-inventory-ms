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
public class Paint {
    
    private int proid,price,qantity;
    String modelname, color;
    
    public Paint(int ProId, String Modelname,String Color,int Price,int Qty)
    {
      this.proid = ProId;
      this.modelname = Modelname;
      this.color = Color;
      this.price = Price;
      this.qantity = Qty;
      
     
    }
    
    public int getID()
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

    public int getprice()
    {
        return price;
    }
    public int getqty()
    {
        return qantity;
    }
    
    
}

    
    
    
    

