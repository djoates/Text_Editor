/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.text_editor;

import com.mycompany.utils.Config;
import java.sql.Connection;
import models.Note;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
<<<<<<< HEAD
            String sql = "INSERT INTO notes (text) VALUES (?)";
=======
            String sql = "INSERT INTO notes (username) VALUES (?)";
>>>>>>> ed478c31f81613e7559a79e7209133c11dbb5678

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
<<<<<<< HEAD
            String sql = "INSERT INTO notes (text) VALUES (?)";
=======
            String sql = "INSERT INTO notes (username) VALUES (?)";
>>>>>>> ed478c31f81613e7559a79e7209133c11dbb5678

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
    
}
    public void DeleteNote(String title, String username) {
        String sql = "DELETE FROM notes WHERE title = ? AND username = ?";
        try (Connection conn = Config.getConnection(); 
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, username);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error deleting note");
        }
    }
    
    public List<Note> getNotesByUser(String username) {
        List<Note> userNotes = new ArrayList<>();
        String sql = "SELECT title, text FROM notes WHERE username = ?";

        try (Connection conn = Config.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Create Note objects from database rows
                    Note note = new Note(rs.getString("title"), rs.getString("text"), username);
                    userNotes.add(note);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching user notes");
        }
        return userNotes;
    }
    
    public Note getSpecificNote(String title, String username) {
    String sql = "SELECT text FROM notes WHERE title = ? AND username = ?";
    
    try (Connection conn = Config.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, title);
        pstmt.setString(2, username);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return new Note(title, rs.getString("text"), username);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error loading full note");
    }
    return null;
}
}
