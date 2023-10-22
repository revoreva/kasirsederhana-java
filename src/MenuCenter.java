/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author imamkahih
 */

// Before:
//public class MenuCenter {
//    protected String[][] menu = {
//        {"Nasi Goreng","12000"},
//        {"Mie Goreng","10000"},
//        {"Kwetiau","11000"},
//        {"Sate Ayam","12500"},
//        {"Ayam Bakar","18000"},
//        {"Ayam Goreng","15000"},
//        {"Teh Botol","6000"},
//        {"Es Teh Manis","5000"},
//        {"Es Jeruk","8000"}
//        
//    };
//}

// After:
public class MenuCenter extends HardcodedListOfdata {
    @Override
    public String[][] getListOfData() {
        String[][] result = {
            {"Nasi Goreng","12000"},
            {"Mie Goreng","10000"},
            {"Kwetiau","11000"},
            {"Sate Ayam","12500"},
            {"Ayam Bakar","18000"},
            {"Ayam Goreng","15000"},
            {"Teh Botol","6000"},
            {"Es Teh Manis","5000"},
            {"Es Jeruk","8000"}

        };
        
        return result;
    }
}
