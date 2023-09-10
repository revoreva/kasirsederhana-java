package Order;


import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import Order.Validation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author imamkahih
 */
public class ValidDigit implements Validation{
     @Override
     public boolean validDigit(KeyEvent b){ //methode untuk mengcek apakah input adalah angka atau tidak
         boolean status = true; // berarti benar digit
        if(b.getKeyChar() == b.VK_BACK_SPACE){
        }else if(!Character.isDigit(b.getKeyChar()) == true){
            status = false; //bukan digit
        }
        return status;
     }
}
