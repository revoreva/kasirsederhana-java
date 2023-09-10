/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuScreen;

import Order.AddCount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reva.yoga
 */
class MenuScreenViewModel {
    final static int MAX_PAGE = 10, MAX_ROW = 3, MAX_COLUMN = 3;
    
    private MenuModel[] menus = new MenuModel[MAX_PAGE * MAX_ROW * MAX_COLUMN + 2];
    MenuModel[][][] gridMenusPerPage = new MenuModel[MAX_PAGE][MAX_ROW][MAX_COLUMN];
    
    void fetchMenus() {
        // TODO: fetch from BE of List MenuModel in Server
        menus[0] = new MenuModel("Nasi Goreng",12000);
        menus[1] = new MenuModel("Mie Goreng",10000);
        menus[2] = new MenuModel("Kwetiau",11000);
        menus[3] = new MenuModel("Sate Ayam",12500);
        menus[4] = new MenuModel("Ayam Bakar",18000);
        menus[5] = new MenuModel("Teh Botol",6000);
        menus[6] = new MenuModel("Es Teh Manis",5000);
        menus[7] = new MenuModel("Es Jeruk",8000);
    }
    
    void splitMenusIntoGrid(javax.swing.GroupLayout menuPanelLayout) {
        int indexOfMenu = 0;
        
        for(int page = 0; page < MAX_PAGE && indexOfMenu < menus.length; page++) {
            for(int row = 0; row < MAX_ROW && indexOfMenu < menus.length; row++) {
                for(int column = 0; column < MAX_ROW && indexOfMenu < menus.length; column++) {
                    MenuModel choosenMenu = menus[indexOfMenu];
                    gridMenusPerPage[page][row][column] = choosenMenu;
                    
                    javax.swing.JButton menuButton = new javax.swing.JButton();
                    menuButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                    menuButton.setText(menus[indexOfMenu].getName());
                    menuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    menuButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            AddCount ac;
                            ac = new AddCount(choosenMenu);
                            ac.setVisible(true);
                        }
                    });
                    
                    menuPanelLayout.setHorizontalGroup(
                        menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 598, Short.MAX_VALUE)
                    );
                    menuPanelLayout.setVerticalGroup(
                        menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 201, Short.MAX_VALUE)
                    );
                    indexOfMenu++;
                }
            }
        }
    }
}
