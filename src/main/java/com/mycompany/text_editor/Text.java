/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.text_editor;

/**
 *
 * @author djzon
 */
public class Text {

    private String fileName;
    private String fileContents;
    private boolean bold;
    private boolean italic;

    public Text(String fileName, String fileContents, boolean bold, boolean italic) {
        this.fileName = fileName;
        this.fileContents = fileContents;
        this.bold = bold;
        this.italic = italic;
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

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

}