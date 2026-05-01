/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.text_editor;
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