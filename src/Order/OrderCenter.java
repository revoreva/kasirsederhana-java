package Order;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import MenuScreen.MenuModel;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author reva.yoga
 */
abstract public class OrderCenter {
    final static int INVALID = -1;
    static List<OrderModel> order = new ArrayList<OrderModel>();
    
    public static int getIndex(MenuModel menu) {
        // perulangan ini dilakukan untuk mengecek apakah menu yang dipesan sudah ada atau belum
        for (int i = 0; i < order.size(); i++) {
            if(menu.getName() == order.get(i).getMenu().getName()){
                return i;
            }
        }
        
        return -1;
    }
    
    public static void setValue(MenuModel menu, int count, String description){ //method untuk menambah & Perbarui pesanan
        int indexCheckMenu = getIndex(menu);
        
        if(indexCheckMenu != -1){ // jika menu yang di pesan sudah ada
            if(count <= 0){ // jika jumlah yang dipesan adalah 0, maka menu tersebut akan di hapus dari pesanan
              order.remove(indexCheckMenu);
            }else{ // jika jumlah pesanan bukan 0, akan memperbarui pesanan yang sudah ada
                order.get(indexCheckMenu).set(count, description); // perbarui jumlah order dan deskripsi di menu tersebut
            }
        }else{ //jika menu yang dipesan tidak ada
            order.add(new OrderModel(menu, count, description)); // memasukan detail menu yang dipesan ke arraylist order
        }
    }
    public static int setDisplay(MenuModel menu) { // method untuk memeriksa menu yang dipilih sudah dipesan atau belum.
        int indexCheckMenu = -1;
        for (int i = 0; i < order.size(); i++) {
            if(menu.getName() == order.get(i).getMenu().getName()){
                indexCheckMenu = i;
            }
        }
        return indexCheckMenu;
    }
    
    public static void clearOrder(){ //methode untuk menghapus semua isi arraylist order & description
        order.clear();
    }
    
    abstract String showAllOrder(); //untuk menampilkan semua order
    
}
