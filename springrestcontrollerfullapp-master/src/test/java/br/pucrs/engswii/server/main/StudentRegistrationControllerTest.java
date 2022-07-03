package br.pucrs.engswii.server.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

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

	@Test
	public void createStudentTest() throws Exception {

		String exampleUserJson = "{\"userID\":\"14\",\"password\":\"123\"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/register/user")
				.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"userID\":\"14\",\"password\":\"123\",\"isLoggedIn\":false,\"registrationStatus\":\"New user successfully created\"}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

//		assertEquals("meu json aqui", result.getResponse());
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
