/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import models.User;
import java.util.List;

/**
 *
 * @author babafemisorinolu
 */

public interface UserDAO {
    void addUser(User user);                           // Add a new room
    List<User> getAllUsers();                         // Retrieve all rooms
    User checkUser(String username , String password);                     // Find room by ID
    
}