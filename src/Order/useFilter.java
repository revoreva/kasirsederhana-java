package Order;


import java.awt.event.KeyEvent;
import Order.Validation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author imamkahih
 */
public class useFilter {
    private Validation valid;

    useFilter(Validation v) {
        this.valid = v;
    }
    
    boolean filterDigit(KeyEvent n){ // untuk mengcek apakah input itu angka atau bukan
        return this.valid.validDigit(n);
    }
    
}
