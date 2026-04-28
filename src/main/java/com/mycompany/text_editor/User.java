/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.text_editor;

/**
 *
 * @author djzon
 */
public class User {
    private int userID;
    private String username;
    private String password;
    
    public User(){
        
    }
    public User(int userId, String Username, String Password){
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
    
    public User(String Username, String Password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
}
