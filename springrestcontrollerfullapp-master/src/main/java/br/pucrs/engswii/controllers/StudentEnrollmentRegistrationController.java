package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pucrs.engswii.beans.*;

@RestController
public class StudentEnrollmentRegistrationController {
	LoginSystem loginSystem = LoginSystem.getInstance();
	//  @RequestMapping(method = RequestMethod.POST, value="/register/student")
	//
	//  @ResponseBody
	@PostMapping("/register/studentenroll")
	public StudentRegistrationReply enrollStudent(
    @RequestParam(value = "subjectCode") String subjectCode, 
    @RequestParam(value = "subjectSchedule") String subjectSchedule,
    @RequestParam(value = "studentRegNumber") String studentRegNumber) {
		if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}

		
		System.out.println("In registerStudent");
        StudentRegistrationReply stdregreply = new StudentRegistrationReply();
        Subject sbj = SubjectRegistration.getInstance().getSubject(subjectCode, subjectSchedule);
        Student std = StudentRegistration.getInstance().getStudentByRegNumber(studentRegNumber);
        EnrolledStudents.getInstance().addSubject(sbj);
        EnrolledStudents.getInstance().addStudent(sbj, std);
        stdregreply.setName(std.getName());
		stdregreply.setAge(std.getAge());
		stdregreply.setRegistrationNumber(std.getRegistrationNumber());
		stdregreply.setRegistrationStatus("Student successfully enrolled");

		return stdregreply;
	}

	

}