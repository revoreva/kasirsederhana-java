/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reva.yoga
 */
public class UsersManagement {
    protected String[][] listUsers = {
        // username, password, role
        {"guest1","guest1","generalUsers"},
        {"guest2","guest2","generalUsers"},
        {"guest3","guest3","generalUsers"},
        {"guest4","guest4","generalUsers"},
        {"guest5","guest5","generalUsers"},
        {"admin","admin","admin"}
    };
    
    enum Role {
        generalUsers,
        admin,
        invalidUsers
    }
}
