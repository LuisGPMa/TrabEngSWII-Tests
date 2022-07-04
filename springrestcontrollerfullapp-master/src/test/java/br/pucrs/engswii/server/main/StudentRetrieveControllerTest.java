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
import br.pucrs.engswii.beans.User;
import br.pucrs.engswii.controllers.StudentRegistrationController;
import br.pucrs.engswii.controllers.StudentRetrieveController;
import br.pucrs.engswii.controllers.UserRegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
import org.skyscreamer.jsonassert.JSONAssert;


@WebMvcTest(value = StudentRegistrationController.class)
//@RunWith(SpringRunner.class)
@Import(StudentRetrieveController.class)
public class StudentRetrieveControllerTest {
    @Autowired
	private MockMvc mockMvc;

	  
	private Student std1 = new Student();
    private Student std2 = new Student();

	@BeforeEach
	public void setup(){
        User usr = mock(User.class);
		LoginSystem.getInstance().setUserLogged(usr);
        StudentRegistration sReg = StudentRegistration.getInstance();        
        std1.setName("Marco");
        std1.setAge(21);
        std1.setRegistrationNumber("1");
        std2.setName("Jose");
        std2.setAge(22);
        std2.setRegistrationNumber("2");
		sReg.add(std1);
        sReg.add(std2);
	}

	@Test
	public void retrieveStudentTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/student/allstudent")
				.accept(MediaType.APPLICATION_JSON).content("{}");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"name\": \"Marco\",\"age\": 21,\"registrationNumber\": \"1\"}, {\"name\": \"Jose\",\"age\": 22,\"registrationNumber\": \"2\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}