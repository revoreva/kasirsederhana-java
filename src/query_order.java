/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


//import java.awt.List;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imamkahih
 */
public class query_order extends OrderCenter{
    
    private String[] menu; //penyimpanan sementara data menu yang diambil
    private int total; // untuk menyimpan total harga menu

    @Override
    public String showAllOrder(){ //untuk menampilkan seluruh menu yang sudah di pesan
        query_order queryOrder = new query_order();
        this.total = 0;
        query_menu queryMenu = new query_menu();
        String temp = "Menu yang sudah di pesan :\n\n";
        System.out.println("sum order: " + OrderCenter.order.size());
        for (int i = 0; i < OrderCenter.order.size(); i++) {
            if(OrderCenter.order.get(i).jumlahPesanan != 0){
                OrderModel currentOrder = OrderCenter.order.get(i);
                
                menu = queryMenu.getMenu(currentOrder.idMenu);
                temp += menu[0] + "\t" + menu[1] + "\tX" + currentOrder.jumlahPesanan + "\t" + 
                        (currentOrder.jumlahPesanan * queryMenu.getIntPrice(menu[1])) +"\n"+ 
                        currentOrder.description + "\n\n";
                this.total += currentOrder.jumlahPesanan * queryMenu.getIntPrice(menu[1]);
            }
        }
        temp += "-------------------------------------------------\n Total : Rp. " + total;
        
        return temp; //dikembalikan dalam type data string
    }
    
    public int totalPayment(){ // untuk mengambil total harga menu yang sudah di pesan
        return total;
    }
}
