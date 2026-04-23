/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.text_editor;

import java.util.List;
import com.mycompany.text_editor.User;
import com.mycompany.utils.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author djzon
 */
public class Login {
    public void addUser(User user)
    {
        String sql = "INSERT INTO customers (username, password) VALUES (?, ?)";

        
        try (Connection conn = Config.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());

            
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User added successfully!");
            }

        } catch (SQLException e) {
            System.err.println("Error adding User: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public List<User> searchUsers(String username, String password) {
        // Search users using a keyword (e.g., name or email).
        // Use SQL LIKE with wildcards (%) for flexible matching.
        // Return a list of matching User objects.
        // return null;
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username = ? and password = ?";
        
        try (Connection conn = Config.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
