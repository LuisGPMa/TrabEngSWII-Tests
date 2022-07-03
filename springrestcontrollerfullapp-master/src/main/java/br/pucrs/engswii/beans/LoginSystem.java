package br.pucrs.engswii.beans;

public class LoginSystem {


    private User usrLogged;
    private static LoginSystem loginsys = null;

    public static LoginSystem getInstance() {

		if(loginsys == null) {
			loginsys = new LoginSystem();
			return loginsys;
		}
		else {
			return loginsys;
		}
	}   

    public LoginSystem(){
        usrLogged = null;
    }

    public void setUserLogged(User usrLogged){
        this.usrLogged = usrLogged;
    }
    public User getUserLogged(){
        return this.usrLogged;
    }
}
