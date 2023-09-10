/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import MenuScreen.MenuModel;

/**
 *
 * @author reva.yoga
 */

// untuk menyimpan menu terpilih, jumlah pesanan, dan deskripsi
public class OrderModel {
    private MenuModel menu;
    private int count;
    private String description;
    
    public OrderModel(MenuModel menu, int count, String description) {
        this.menu = menu;
        this.count = count;
        this.description = description;
    }
    
    public void set(int count, String description) {
        this.count = count;
        this.description = description;
    }
    
    public MenuModel getMenu() {
        return menu;
    }
    
    public int getCount() {
        return count;
    }
    
    public String getDescription() {
        return description;
    }
}
