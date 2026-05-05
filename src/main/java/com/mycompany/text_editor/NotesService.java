/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.text_editor;

import com.mycompany.utils.Config;
import models.Note;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djzon
 */
public class NotesService {
    public void CreateText(Note note){
        try {
            // SQL query with placeholders (?) for values we will set later
            String sql = "INSERT INTO notes (username) VALUES (?)";

            // Get the database connection and prepare the statement
            PreparedStatement preparedStatement = Config.getConnection().prepareStatement(sql);

            // Set values for each placeholder (index starts at 1)
            // 1 → room_number column
            String title = note.getFileName();
            preparedStatement.setString(1, title);


            // Execute the INSERT query (used for INSERT, UPDATE, DELETE)
            preparedStatement.executeUpdate();

            System.out.println("Text Created successfully!");

        } catch (SQLException ex) {
            // If something goes wrong, print the error in the console
            Logger.getLogger(UserService.class.getName())
                    .log(Level.SEVERE, "Error adding note", ex);
        
    }}
    
    
    public void SaveText(Note text){
        try {
            // SQL query with placeholders (?) for values we will set later
            String sql = "INSERT INTO users (text) VALUES (?)";

            // Get the database connection and prepare the statement
            PreparedStatement preparedStatement = Config.getConnection().prepareStatement(sql);

            // Set values for each placeholder (index starts at 1)
            // 1 → room_number column
            String buffer = text.getSave();
            preparedStatement.setString(1, buffer);


            // Execute the INSERT query (used for INSERT, UPDATE, DELETE)
            preparedStatement.executeUpdate();

            System.out.println("Text Saved Successfully!");

        } catch (SQLException ex) {
            // If something goes wrong, print the error in the console
            Logger.getLogger(UserService.class.getName())
                    .log(Level.SEVERE, "Error adding note", ex);
        
    
    }
    
}}
