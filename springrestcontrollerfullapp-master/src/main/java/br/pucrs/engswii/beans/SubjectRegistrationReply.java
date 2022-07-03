package br.pucrs.engswii.beans;

import java.util.List;

public class SubjectRegistrationReply {
    
    String code;
    String name;
    String schedule;
	String registrationStatus;

    public String getCode() {
		return code;
	}
	public void setCode(String Code) {
		this.code = Code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public void setRegistrationStatus(String registrationStatus){
		this.registrationStatus = registrationStatus;
	}
	public String getRegistrationStatus(){
		return this.registrationStatus;
	}

}
