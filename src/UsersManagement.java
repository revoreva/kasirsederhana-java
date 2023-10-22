/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reva.yoga
 */

// Before:
//public class UsersManagement {
//    protected String[][] listUsers = {
//        // username, password, role
//        {"kasir1","kasir1","generalUsers"},
//        {"kasir2","kasir2","generalUsers"},
//        {"kasir3","kasir3","generalUsers"},
//        {"kasir4","kasir4","generalUsers"},
//        {"kasir5","kasir5","generalUsers"},
//        {"admin","admin","admin"}
//    };
//    
//    enum Role {
//        generalUsers,
//        admin,
//        invalidUsers
//    }
//}

// After:
public class UsersManagement extends HardcodedListOfdata {
    
    @Override
    public String[][] getListOfData() {
        String[][] result = {
            // username, password, role
            {"kasir1","kasir1","generalUsers"},
            {"kasir2","kasir2","generalUsers"},
            {"kasir3","kasir3","generalUsers"},
            {"kasir4","kasir4","generalUsers"},
            {"kasir5","kasir5","generalUsers"},
            {"admin","admin","admin"}
        };
        
        return result;
    }
    
    enum Role {
        generalUsers,
        admin,
        invalidUsers
    }
}
