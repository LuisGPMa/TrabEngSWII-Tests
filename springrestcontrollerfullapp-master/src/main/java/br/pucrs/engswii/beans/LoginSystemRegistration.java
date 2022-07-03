package br.pucrs.engswii.beans;

public class LoginSystemRegistration {

    private User usrLogged;

    private static LoginSystemRegistration loginsysreg = null;

    private LoginSystemRegistration(){
		usrLogged = null;
	}

	public static LoginSystemRegistration getInstance() {

		if(loginsysreg == null) {
			loginsysreg = new LoginSystemRegistration();
			return loginsysreg;
		}
		else {
			return loginsysreg;
		}
	}
	public boolean processLogins(User userLogin){	
		LoginSystem loginSystem = LoginSystem.getInstance();
		
		for (User userInList : UserRegistration.getInstance().getUserRecords()) {
			if (userInList.getUserID().equals(userLogin.getUserID())){
				if (userInList.getPassword().equals(userLogin.getPassword())){

					/*update system login state  */
					loginSystem.setUserLogged(userLogin);

					/*update User in UserRecords login state*/

					userLogin.setIsLoggedIn(true);
					UserRegistration.getInstance().upDateUser(userLogin);
					
					return true;
				}
			}
		}
		
		return false;
	}

    
}
