package br.pucrs.engswii.beans;

public class User {
    private String userID;
    private String password;
    private boolean isLoggedIn;

    public String getUserID(){
        return this.userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setIsLoggedIn(boolean isLogged){
        this.isLoggedIn = isLogged;
    }
    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }
}
