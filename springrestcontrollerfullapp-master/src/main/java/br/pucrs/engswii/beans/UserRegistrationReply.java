package br.pucrs.engswii.beans;

public class UserRegistrationReply {

	private String userID;
	private String password;
	private boolean isLoggedIn;
	private String registrationStatus;

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public void setIsLoggedIn(boolean isLogged){
        this.isLoggedIn = isLogged;
    }
    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }
}
