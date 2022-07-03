package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pucrs.engswii.beans.EnrolledStudents;
import br.pucrs.engswii.beans.LoginSystem;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistration;
import br.pucrs.engswii.beans.Subject;
import br.pucrs.engswii.beans.SubjectRegistration;

@RestController
public class StudentEnrollmentRetrieveController {
    LoginSystem loginSystem = LoginSystem.getInstance();
    //	@RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
    //
    //	@ResponseBody
    @GetMapping("/subject/allstudent")
    public List<Student> getStudentsInSubject(
    @RequestParam(value = "subjectCode") String subjectCode, 
    @RequestParam(value = "subjectSchedule") String subjectSchedule) {
        if(loginSystem.getUserLogged()==null){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nao encontrado login");
		}

        Subject sbj = SubjectRegistration.getInstance().getSubject(subjectCode, subjectSchedule);    
        return EnrolledStudents.getInstance().getEnrolledStudents(sbj);
    }

}
