package br.pucrs.engswii.server.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import br.pucrs.engswii.beans.LoginSystemRegistration;
import br.pucrs.engswii.beans.User;
import br.pucrs.engswii.controllers.UserRegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
import org.skyscreamer.jsonassert.JSONAssert;


@WebMvcTest(value = UserRegistrationController.class)
public class UserLoginTest {
    @Autowired
	private MockMvc mockMvc;

    @MockBean   
	private LoginSystemRegistration loginSystemRegistration;

    private String exampleUserJson = "{\"userID\":\"14\",\"password\":\"123\"}";

	@Test
	public void userLoginTest() throws Exception {
        Mockito.when(
            loginSystemRegistration.processLogins(Mockito.any(User.class))).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/login")
				.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("response" + result.getResponse());
		String expected = "{\"userID\":\"14\",\"password\":\"123\"}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

//		assertEquals("meu json aqui", result.getResponse());
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
