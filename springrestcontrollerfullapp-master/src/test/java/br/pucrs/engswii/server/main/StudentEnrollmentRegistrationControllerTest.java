package br.pucrs.engswii.server.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import br.pucrs.engswii.beans.LoginSystem;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistration;
import br.pucrs.engswii.beans.Subject;
import br.pucrs.engswii.beans.SubjectRegistration;
import br.pucrs.engswii.beans.User;
import br.pucrs.engswii.controllers.StudentEnrollmentRegistrationController;
import br.pucrs.engswii.controllers.StudentRegistrationController;
import br.pucrs.engswii.controllers.UserRegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
import org.skyscreamer.jsonassert.JSONAssert;


@WebMvcTest(value = StudentEnrollmentRegistrationController.class)
public class StudentEnrollmentRegistrationControllerTest {
    @Autowired
	private MockMvc mockMvc;

	@MockBean   
	private LoginSystem loginSystem;

	private String subjectCode = "4646A";
	private String subjectSchedule = "AB";
	private String studentRegNumber = "1";

	@BeforeEach
	public void setup(){
		User usr = mock(User.class);
		LoginSystem.getInstance().setUserLogged(usr);
		Student std = new Student();
		StudentRegistration stdReg = StudentRegistration.getInstance();        
        std.setName("Marco");
        std.setAge(21);
        std.setRegistrationNumber(studentRegNumber);
		stdReg.add(std);
		SubjectRegistration sbjReg = SubjectRegistration.getInstance();
		Subject sbj = new Subject();
		sbj.setCode(subjectCode);   
        sbj.setName("TCC");
		sbj.setSchedule(subjectSchedule);
		sbjReg.add(sbj);
	}

	@Test
	public void studentEnrollTest() throws Exception {


		// Mockito.when(
		// 	loginSystem.getUserLogged()).thenReturn(new User());

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/register/studentenroll")
				.param("subjectCode", subjectCode)
				.param("subjectSchedule", subjectSchedule)
				.param("studentRegNumber", studentRegNumber)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"name\": \"Marco\",\"age\": 21,\"registrationNumber\": \"1\",\"registrationStatus\": \"Student successfully enrolled\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
} 