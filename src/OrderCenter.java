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

class MenuOrdered {
    int idMenu, jumlahPesanan;
    String description;
    
    void set(int idMenu, int jumlahPesanan, String description) {
        this.idMenu = idMenu;
        this.jumlahPesanan = jumlahPesanan;
        this.description = description;
    }
}

class OrderDate {
    int date = 0, month = 0, year = 0;
}

class AllOrder {
    List<MenuOrdered> allMenuOrdered = new ArrayList<MenuOrdered>(); //untuk menyimpan id menu, jumlah pesanan, deskripsi dari pesanan
    String paymentMethod = "", kasirName = "";
    OrderDate orderDate = new OrderDate();
}

abstract class OrderCenter {
    private static List<AllOrder> allOrder = new ArrayList<AllOrder>(); //untuk menyimpan semua order
    
    public static AllOrder currentOrder() {
        int currentSize = allOrder.size();
        
        if(currentSize == 0) {
            finishAnOrder();
            currentSize++;
        }
        
        return allOrder.get(currentSize-1);
    }
    
    public static AllOrder orderAt(int at) {
        return allOrder.get(at);
    }
    
    public static int sumOrder() {
        return allOrder.size();
    }
    
    public static void finishAnOrder() {
        AllOrder order = new AllOrder();
        allOrder.add(order);
    }
    
    public static void setValue(int indexOrder, int indexMenu, int count, String desc) { //method untuk menambah & Perbarui pesanan
        if(indexOrder >= currentOrder().allMenuOrdered.size()) { // new allMenuOrdered
            MenuOrdered currentOrder = new MenuOrdered();
            currentOrder.set(indexMenu, count, desc);// id menu, jumlah pesanan, deskripsi, dimasukan kedalam arraylist
            currentOrder().allMenuOrdered.add(currentOrder);
        } else {
            if(count <= 0) { // jika jumlah yang dipesan adalah 0, maka menu tersebut akan di hapus dari pesanan
                currentOrder().allMenuOrdered.remove(indexOrder);
            } else { // jika jumlah pesanan bukan 0, akan memperbarui pesanan yang sudah ada
                currentOrder().allMenuOrdered.get(indexOrder).set(indexMenu, count, desc);
            }
        }
    }
    
    public static List<Integer> setDisplay(int index) { // metode untuk memeriksa menu yang dipilih sudah dipesan atau belum.
        List<Integer> indexOrder = new ArrayList<>();
        for (int i = 0; i < currentOrder().allMenuOrdered.size(); i++) {
            if(index == currentOrder().allMenuOrdered.get(i).idMenu){
                indexOrder.add(i);
            }
        }
        return indexOrder;
    }
    
    abstract String showAllOrder(int indexReceipt); //untuk menampilkan semua allMenuOrdered
    
}
