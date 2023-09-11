/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author imamkahih
 */
abstract class order_center {
    static List<List<Integer>> order = new ArrayList<>(); //untuk menyimpan id menu & jumlah pesanan
    static List<String> description = new ArrayList<>(); //untuk menyimpan deskripsi dari pesanan
    
    public static void setValue(int index, int count, String desc, boolean isNewOrder) { //method untuk menambah & Perbarui pesanan
        if(isNewOrder) {
            Integer[] temp = {index,count}; // id menu & jumlah pesanan dimaukan kedalam arraylist
            order.add(new ArrayList(Arrays.asList(temp))); // memasukan arraylist menu yang dipesan ke arraylist order
            description.add(desc); //memasukan deskripsi pesanan
        } else {
            if(count <= 0) { // jika jumlah yang dipesan adalah 0, maka menu tersebut akan di hapus dari pesanan
                order.remove(index);
                description.remove(index);
            } else { // jika jumlah pesanan bukan 0, akan memperbarui pesanan yang sudah ada
                order.get(index).set(1, count); // perbarui id menu
                description.set(index, desc); // perbarui deskripsi
            }
        }
    }
    public static int setDisplay(int index){ // methode untuk memeriksa menu yang dipilih sudah dipesan atau belum.
        int cek = -1;
        for (int i = 0; i < order.size(); i++) {
            if(index == order.get(i).get(0)){
                cek = i;
            }
        }
        return cek;
    }
    
    public static void clearOrder(){ //methode untuk menghapus semua isi arraylist order & description
        order.clear();
        description.clear();
    }
    
    abstract String showAllOrder(); //untuk menampilkan semua order
    
}
