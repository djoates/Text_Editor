/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.text_editor;

import Interfaces.NotesDAO;
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
public class NotesService implements NotesDAO{

    // 1. Create a new Note entry
    @Override
    public void CreateText(Note note) {
    // Ensure 'text' matches your database column name exactly
    String sql = "INSERT INTO notes (title, text, username) VALUES (?, ?, ?)";
    try (Connection conn = Config.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, note.getFileName());
        pstmt.setString(2, note.getFileContents()); // This is the empty string "" from your button
        pstmt.setString(3, note.getUsername());

        pstmt.executeUpdate();
        System.out.println("Text Created successfully!");

    } catch (SQLException ex) {
        // This will now print the EXACT reason if it fails again
        System.out.println("Error creating note: " + ex.getMessage());
    }
}

    // 2. Save/Update existing note content
    @Override
    public void SaveText(Note note) {
        // Updates the text based on the title and owner
        String sql = "UPDATE notes SET text = ? WHERE title = ? AND username = ?";
        try (Connection conn = Config.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, note.getFileContents());
            pstmt.setString(2, note.getFileName());
            pstmt.setString(3, note.getUsername());

            pstmt.executeUpdate();
            System.out.println("Text Saved Successfully!");

        } catch (SQLException ex) {
            System.out.println("Error saving note: " + ex.getMessage());
        }
    }

    // 3. Delete a note
    @Override
    public void DeleteNote(String title, String username) {
        String sql = "DELETE FROM notes WHERE title = ? AND username = ?";
        try (Connection conn = Config.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            System.out.println("Note deleted: " + title);

        } catch (SQLException ex) {
            System.out.println("Error deleting note: " + ex.getMessage());
        }
    }

    // 4. Fetch all notes for a specific user (Used for jTable)
    @Override
    public List<Note> getNotesByUser(String username) {
        List<Note> userNotes = new ArrayList<>();
        String sql = "SELECT title, text FROM notes WHERE username = ?";

        try (Connection conn = Config.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Pulls title and text into the Note object[cite: 1]
                    Note note = new Note(rs.getString("title"), rs.getString("text"), username);
                    userNotes.add(note);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching user notes: " + ex.getMessage());
        }
        return userNotes;
    }

    // 5. Load the full content of a specific note
    @Override
    public Note getSpecificNote(String title, String username) {
        String sql = "SELECT text FROM notes WHERE title = ? AND username = ?";

        try (Connection conn = Config.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Note(title, rs.getString("text"), username);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error loading specific note: " + ex.getMessage());
        }
        return null;
    }
}
