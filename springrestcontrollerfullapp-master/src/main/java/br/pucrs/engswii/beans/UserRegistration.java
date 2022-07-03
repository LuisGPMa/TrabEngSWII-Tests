package br.pucrs.engswii.beans;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {

	private List<User> userRecords;

	private static UserRegistration usrregd = null;

	private UserRegistration(){
		userRecords = new ArrayList<User>();
	}

	public static UserRegistration getInstance() {

		if(usrregd == null) {
			usrregd = new UserRegistration();
			return usrregd;
		}
		else {
			return usrregd;
		}
	}

	public String add(User newUser) {
		String newUserID = newUser.getUserID();
		for(int i=0; i<userRecords.size(); i++)
		{
			User usr = userRecords.get(i);
			if(usr.getUserID().equals(newUserID)) {
				return "Error - ID alread exists";
			}
		}

		userRecords.add(newUser);
		return "New user successfully created";
	}

	public String upDateUser(User updatedUsr) {

		for(int i=0; i<userRecords.size(); i++)
		{
			User usr = userRecords.get(i);
			if(usr.getUserID().equals(updatedUsr.getUserID())) {
				userRecords.set(i, updatedUsr);//update the new record
				return "Update successful";
			}
		}

		return "Update un-successful";
	}

	public String deleteUser(String userID) {

		for(int i=0; i<userRecords.size(); i++)
		{
			User usr = userRecords.get(i);
			if(usr.getUserID().equals(userID)){
				userRecords.remove(i);//update the new record
				return "Delete successful";
			}
		}

		return "Delete un-successful";
	}

	public List<User> getUserRecords() {
		return userRecords;
	}

}