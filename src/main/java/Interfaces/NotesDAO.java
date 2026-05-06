/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;
import models.Note;

/**
 *
 * @author Alex
 */
public interface NotesDAO {
    // 1. Create a new Note entry
    void CreateText(Note note);

    // 2. Save/Update existing note content
    void SaveText(Note note);

    // 3. Delete a note
    void DeleteNote(String title, String username);

    // 4. Fetch all notes for a specific user (Used for jTable)
    List<Note> getNotesByUser(String username);

    // 5. Load the full content of a specific note
    Note getSpecificNote(String title, String username);
 
}
