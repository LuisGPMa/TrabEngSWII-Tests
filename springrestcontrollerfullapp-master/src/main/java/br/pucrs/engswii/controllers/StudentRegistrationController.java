package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class StudentRegistrationController {
	
	// @Autowired
	// private LoginSystem loginSystem;

	LoginSystem loginSystem = LoginSystem.getInstance();

	//  @RequestMapping(method = RequestMethod.POST, value="/register/student")
	//
	//  @ResponseBody
	@PostMapping("/register/student")
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}

		System.out.println("In registerStudent");
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();           
		String statusReply = StudentRegistration.getInstance().add(student);
		stdregreply.setName(student.getName());
		stdregreply.setAge(student.getAge());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus(statusReply);

		return stdregreply;
	}

	// @PostMapping("/register/student")
	// public StudentRegistrationReply registerStudent(@RequestBody Student student,@RequestParam(name = "testMode", defaultValue = "false") Boolean testMode) {
	// 	if(loginSystem.getUserLogged(testMode)==null){
	// 		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
	// 	}

	// 	System.out.println("In registerStudent");
	// 	StudentRegistrationReply stdregreply = new StudentRegistrationReply();           
	// 	String statusReply = StudentRegistration.getInstance().add(student);
	// 	stdregreply.setName(student.getName());
	// 	stdregreply.setAge(student.getAge());
	// 	stdregreply.setRegistrationNumber(student.getRegistrationNumber());
	// 	stdregreply.setRegistrationStatus(statusReply);

	// 	return stdregreply;
	// }

}
