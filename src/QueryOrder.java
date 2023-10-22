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
public class QueryOrder extends OrderCenter {
    
    private String[] menu; //penyimpanan sementara data menu yang diambil
    private int total; // untuk menyimpan total harga menu
    private String temp;

    @Override
    public String showAllOrder(int indexReceipt){ //untuk menampilkan seluruh menu yang sudah di pesan
        AllOrder currentOrder;
        
        System.out.println("indexReceipt in order: " + indexReceipt);
        
        if(indexReceipt == -1) {
            currentOrder = OrderCenter.currentOrder();
        } else {
            currentOrder = OrderCenter.orderAt(indexReceipt);
        }
        
        
        QueryOrder queryOrder = new QueryOrder();
        this.total = 0;
        QueryMenu queryMenu = new QueryMenu();
        temp = "Menu yang sudah di pesan :\n\n";
        System.out.println("sum order: " + currentOrder.allMenuOrdered.size());
        currentOrder.allMenuOrdered.forEach( (currentMenuOrdered) -> {
            if(currentMenuOrdered.jumlahPesanan != 0){
                
                menu = queryMenu.getMenu(currentMenuOrdered.idMenu);
                temp += menu[0] + "\t" + menu[1] + "\tX" + currentMenuOrdered.jumlahPesanan + "\t" + 
                        (currentMenuOrdered.jumlahPesanan * queryMenu.getIntPrice(menu[1])) +"\n"+ 
                        currentMenuOrdered.description + "\n\n";
                this.total += currentMenuOrdered.jumlahPesanan * queryMenu.getIntPrice(menu[1]);
            }
        });
        temp += "-------------------------------------------------\n Total : Rp. " + total;
        
        String currentPaymentMethod = currentOrder.paymentMethod;
        if(!currentPaymentMethod.isEmpty()) {
            temp += "\n\n-------------------------------------------------\n\n Metode Pembayaran : " + currentPaymentMethod;
            
            OrderDate currentOrderDate = currentOrder.orderDate;
            temp += "\n\n-------------------------------------------------\n\n Tanggal Nota : " + currentOrderDate.date + "-" + currentOrderDate.month + "-" + currentOrderDate.year;
        }
        
        String currentKasirName = currentOrder.kasirName;
        if(!currentKasirName.isEmpty()) {
            temp += "\n\n-------------------------------------------------\n\n Nama Kasir : " + currentKasirName;
        }
        
        return temp; //dikembalikan dalam type data string
    }
    
    public int totalPayment(){ // untuk mengambil total harga menu yang sudah di pesan
        return total;
    }
}
