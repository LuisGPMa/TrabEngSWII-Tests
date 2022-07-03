package br.pucrs.engswii.server.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import br.pucrs.engswii.beans.LoginSystem;
import br.pucrs.engswii.beans.User;
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


@WebMvcTest(value = StudentRegistrationController.class)
public class StudentRegistrationControllerTest {
    @Autowired
	private MockMvc mockMvc;

	@MockBean   
	private LoginSystem loginSystem;

	@BeforeEach
	public void setup(){
		User usr = mock(User.class);
		LoginSystem.getInstance().setUserLogged(usr);
	}

	@Test
	public void createStudentTest() throws Exception {

		String exampleStudentJson = "{\"name\":\"Marco\",\"age\":21,\"registrationNumber\":\"1\",\"registrationStatus\":\"New Student successfully added\"}";

		// Mockito.when(
		// 	loginSystem.getUserLogged()).thenReturn(new User());

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/register/student")
				.accept(MediaType.APPLICATION_JSON).content(exampleStudentJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"name\":\"Marco\",\"age\":21,\"registrationNumber\":\"1\",\"registrationStatus\":\"New Student successfully added\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
} 