package br.pucrs.engswii.server.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import br.pucrs.engswii.beans.LoginSystem;
import br.pucrs.engswii.beans.User;
import br.pucrs.engswii.controllers.SubjectRegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
import org.skyscreamer.jsonassert.JSONAssert;


@WebMvcTest(value = SubjectRegistrationController.class)
public class SubjectRegistrationControllerTest {
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
	public void createSubjectTest() throws Exception {

		String exampleSubjectJson = "{\"code\" : \"4646c\",\"name\" : \"tcc\",\"schedule\" : \"AB\"}";

		// Mockito.when(
		// 	loginSystem.getUserLogged()).thenReturn(new User());

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/subject/register")
				.accept(MediaType.APPLICATION_JSON).content(exampleSubjectJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"code\": \"4646c\",\"name\": \"tcc\",\"schedule\": \"AB\",\"registrationStatus\": \"New Subject successfully created\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
} 