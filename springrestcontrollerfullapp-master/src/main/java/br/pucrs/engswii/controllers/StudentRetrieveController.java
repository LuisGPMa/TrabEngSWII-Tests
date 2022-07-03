package br.pucrs.engswii.controllers;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.pucrs.engswii.beans.LoginSystem;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistration;

@RestController
public class StudentRetrieveController {

	LoginSystem loginSystem = LoginSystem.getInstance();
	//	@RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	//
	//	@ResponseBody
	@GetMapping("/student/allstudent")
	public List<Student> getAllStudents() {
		if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}

		return StudentRegistration.getInstance().getStudentRecords();
	}

	@GetMapping("/student/studentbynameseg")
	public List<Student> getStudentByNameSegment(@RequestParam(value = "nameSeg") String nameSeg) {
		if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}

		return StudentRegistration.getInstance().getStudentByNameSegment(nameSeg);
	}

	@GetMapping("/student/studentbyregnumber")
	public Student getStudentByRegNumber(@RequestParam(value = "registrationNumber") String registrationNumber) {
		if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}
		
		return StudentRegistration.getInstance().getStudentByRegNumber(registrationNumber);
	}
}
