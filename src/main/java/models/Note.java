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
    private String buffer="";
    
    public Note(String fileName){
        this.fileName = fileName;
        this.buffer = this.fileName +"||";
        
    }

    public Note(String fileName, String fileContents, boolean bold, boolean italic) {
        
    }


    public Note(String fileName, String fileContents) {
        this.fileName = fileName;
        this.fileContents = fileContents;
    }
    
    public void Save(String contents){
        buffer = this.fileName +"||" + contents;
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
