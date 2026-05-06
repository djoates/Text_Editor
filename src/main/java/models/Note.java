/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author djzon
 */
public class Note {

    private String fileName;
    private String fileContents;
    private boolean bold;
    private boolean italic;
    private String username;
    private String buffer="";
    
    public Note(String fileName, String string, String username){
        this.fileName = fileName;
        this.buffer = this.fileName +"||";
        this.username = username;
        
    }

    public Note(String fileName, String fileContents, boolean bold, boolean italic) {
    this.fileName = fileName;
    this.fileContents = fileContents;
    this.bold = bold;
    this.italic = italic;
    this.buffer = fileName + "||" + fileContents;
}


    public Note(String fileName, String fileContents) {
        this.fileName = fileName;
        this.fileContents = fileContents;
    }
    
    public void Save(String contents) {
        this.fileContents = contents;
        this.buffer = this.fileName + "||" + contents;
    }
    
    public String getSave(){
        return buffer;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

}
