package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pucrs.engswii.beans.*;

@RestController
public class SubjectRegistrationController {
	LoginSystem loginSystem = LoginSystem.getInstance();

	//  @RequestMapping(method = RequestMethod.POST, value="/register/student")
	//
	//  @ResponseBody
	@PostMapping("/subject/register")
	public SubjectRegistrationReply registerSubject(@RequestBody Subject subject) {
		if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}
		System.out.println("In registerSubject");
		SubjectRegistrationReply sbjregreply = new SubjectRegistrationReply();           
		String statusRply = SubjectRegistration.getInstance().add(subject);
		//We are setting the below value just to reply a message back to the caller
		sbjregreply.setName(subject.getName());
		sbjregreply.setCode(subject.getCode());
		sbjregreply.setSchedule(subject.getSchedule());
		sbjregreply.setRegistrationStatus(statusRply);

		return sbjregreply;
	}

}
