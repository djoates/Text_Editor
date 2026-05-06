/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.text_editor;

import models.User;
import Interfaces.UserDAO;
import com.mycompany.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author babafemisorinolu
 */
public class UserService implements UserDAO {

    @Override
    public void addUser(User user) {
        try {
            // SQL query with placeholders (?) for values we will set later
            String sql = "INSERT INTO users (username, password) VALUES (?,?)";

            // Get the database connection and prepare the statement
            PreparedStatement preparedStatement = Config.getConnection().prepareStatement(sql);

            // Set values for each placeholder (index starts at 1)
            // 1 → room_number column
            preparedStatement.setString(1, user.getUsername());

            // 2 → type column
            preparedStatement.setString(2, user.getPassword());

            // Execute the INSERT query (used for INSERT, UPDATE, DELETE)
            preparedStatement.executeUpdate();

            System.out.println("User added successfully!");

        } catch (SQLException ex) {
            // If something goes wrong, print the error in the console
            Logger.getLogger(UserService.class.getName())
                    .log(Level.SEVERE, "Error adding user", ex);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users";
            PreparedStatement ps = Config.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Loop through all rows returned from DB
            while (rs.next()) {
                User user = new User();

                // Map DB columns to object fields
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User checkUser(String username, String password) {
        User user = null;

        try {
            String sql = "SELECT * FROM users WHERE username = ? and password=?";
            PreparedStatement ps = Config.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            // If a result exists, create the object
            if (rs.next()) {

                String u_name = rs.getString("username");
                String p_word = rs.getString("password");

                user = new User(u_name, p_word);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean isUsernameTaken(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
