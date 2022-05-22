package com.example.Main;


public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private boolean isAdmin;
    
    public User(){}

    public User(int userId, String firstName, String lastName, String userName, String password, String email, boolean isAdmin) {
        // constructor for Adimn only
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public User(int userId, String firstName, String userName, String password) { 
        this.userId = userId;
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.isAdmin = false;
        this.lastName = "";
        this.email = "Not registered";
        
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    
    
    
    
    
    
  
}
