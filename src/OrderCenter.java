/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author reva.yoga
 */

class OrderModel {
    int idMenu, jumlahPesanan;
    String description;
    
    void set(int idMenu, int jumlahPesanan, String description) {
        this.idMenu = idMenu;
        this.jumlahPesanan = jumlahPesanan;
        this.description = description;
    }
}

abstract class OrderCenter {
    static List<OrderModel> order = new ArrayList<OrderModel>(); //untuk menyimpan id menu, jumlah pesanan, deskripsi dari pesanan
    
    public static void setValue(int indexOrder, int indexMenu, int count, String desc) { //method untuk menambah & Perbarui pesanan
        if(indexOrder >= order.size()) { // new order
            OrderModel currentOrder = new OrderModel();
            currentOrder.set(indexMenu, count, desc);// id menu, jumlah pesanan, deskripsi, dimasukan kedalam arraylist
            order.add(currentOrder);
        } else {
            if(count <= 0) { // jika jumlah yang dipesan adalah 0, maka menu tersebut akan di hapus dari pesanan
                order.remove(indexOrder);
            } else { // jika jumlah pesanan bukan 0, akan memperbarui pesanan yang sudah ada
                order.get(indexOrder).set(indexMenu, count, desc);
            }
        }
    }
    
    public static List<Integer> setDisplay(int index) { // metode untuk memeriksa menu yang dipilih sudah dipesan atau belum.
        List<Integer> indexOrder = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            if(index == order.get(i).idMenu){
                indexOrder.add(i);
            }
        }
        return indexOrder;
    }
    
    public static void clearOrder(){ //methode untuk menghapus semua isi arraylist order & description
        order.clear();
    }
    
    abstract String showAllOrder(); //untuk menampilkan semua order
    
}
