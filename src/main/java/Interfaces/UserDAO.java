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

    // Create: Used for registration
    void addUser(User user);

    // Read: Used for admin lists or debugging
    List<User> getAllUsers();

    // Authenticate: Used for login
    User checkUser(String username, String password);

    // Validation: Prevents duplicate usernames during registration
    boolean isUsernameTaken(String username);
}
