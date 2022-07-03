package br.pucrs.engswii.controllers;

import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pucrs.engswii.beans.LoginSystem;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistration;

@RestController
public class StudentUpdateController {
	

	LoginSystem loginSystem = LoginSystem.getInstance();
//	@RequestMapping(method = RequestMethod.PUT, value="/update/student")
//
//
//	@ResponseBody
	@PutMapping("/update/student")
	public String updateStudentRecord(@RequestBody Student stdn) {
		if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}		
		System.out.println("In updateStudentRecord");   
		return StudentRegistration.getInstance().upDateStudent(stdn);
	}

}
