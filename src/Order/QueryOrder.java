package Order;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


//import java.awt.List;
import Order.OrderCenter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imamkahih
 */
public class QueryOrder extends OrderCenter {
    
    private String[] menu; //penyimpanan sementara data menu yang diambil
    private int total; // untuk menyimpan total harga menu

    @Override
    public String showAllOrder(){ //untuk menampilkan seluruh menu yang sudah di pesan
        QueryOrder qo = new QueryOrder();
        this.total = 0;
        QueryMenu qMenu = new QueryMenu();
        String temp = "Menu yang sudah di pesan :\n\n";
        for (int i = 0; i < OrderCenter.order.size(); i++) {
            if(OrderCenter.order.get(i).get(1)!= 0){
                menu = qMenu.getMenu(OrderCenter.order.get(i).get(0));
                temp += menu[0] + "\t" + menu[1] + "\tX" + OrderCenter.order.get(i).get(1) + "\t" + 
                        (OrderCenter.order.get(i).get(1) * qMenu.getIntPrice(menu[1])) +"\n"+ 
                        OrderCenter.description.get(i)+ "\n\n";
                this.total += OrderCenter.order.get(i).get(1) * qMenu.getIntPrice(menu[1]);
            }
        }
        temp += "-------------------------------------------------\n Total : Rp. " + total;
        
        return temp; //dikembalikan dalam type data string
    }
    
    public int totalPayment(){ // untuk mengambil total harga menu yang sudah di pesan
        return total;
    }
}
