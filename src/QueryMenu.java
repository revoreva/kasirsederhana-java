/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author imamkahih
 */
public class QueryMenu extends MenuCenter {
    
    public String[] getMenu(int id){ //methode untuk mengambil data menu dalam bentuk string array
        return this.getListOfData()[id];
    }
    
    public int getIntPrice(String price){ //methode untuk mengubah type data harga dari string menjadi integer
        return Integer.parseInt(price);
    }
    
}
