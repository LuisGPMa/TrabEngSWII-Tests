package br.pucrs.engswii.beans;

public class LoginSystemReply {

	User user;
	boolean loginsys;
	

	public User getName() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean getloginSys() {
		return loginsys;
	}
	public void setloginSys(boolean loginsys) {
		this.loginsys = loginsys;
	}

}
