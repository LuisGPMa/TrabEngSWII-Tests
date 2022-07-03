package br.pucrs.engswii.beans;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {

	private List<Student> studentRecords;

	private static StudentRegistration stdregd = null;

	private StudentRegistration(){
		studentRecords = new ArrayList<Student>();
	}

	public static StudentRegistration getInstance() {

		if(stdregd == null) {
			stdregd = new StudentRegistration();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}

	public String add(Student newStd) {
		String newStdRegNumber = newStd.getRegistrationNumber();
		for(int i=0; i<studentRecords.size(); i++)
		{
			Student std = studentRecords.get(i);
			if(std.getRegistrationNumber().equals(newStdRegNumber)) {
				return "Error - Registration Number already exists";
			}
		}

		studentRecords.add(newStd);
		return "New Student successfully added";
	}

	public List<Student> getStudentByNameSegment(String nameSeg){
		List<Student> rply = new ArrayList<Student>();
		for(Student s: studentRecords){
			if(s.getName().contains(nameSeg)){
				rply.add(s);
			}
		}
		return rply;
	}

	public Student getStudentByRegNumber(String regNumber){
		Student rply = null;
		for(Student s: studentRecords){
			if(s.getRegistrationNumber().equals(regNumber)){
				rply = s;
				break;
			}
		}
		return rply;
	}

	public String upDateStudent(Student std) {

		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
				studentRecords.set(i, std);//update the new record
				return "Update successful";
			}
		}

		return "Update un-successful";
	}

	public String deleteStudent(String registrationNumber) {

		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getRegistrationNumber().equals(registrationNumber)){
				studentRecords.remove(i);//update the new record
				return "Delete successful";
			}
		}

		return "Delete un-successful";
	}

	public List<Student> getStudentRecords() {
		return studentRecords;
	}

}