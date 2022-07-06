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
import br.pucrs.engswii.controllers.StudentRegistrationController;
import br.pucrs.engswii.controllers.StudentRetrieveController;
import br.pucrs.engswii.controllers.SubjectRegistrationController;
import br.pucrs.engswii.controllers.SubjectRetrieveController;
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


@WebMvcTest(value = SubjectRetrieveController.class)
//@RunWith(SpringRunner.class)
@Import(SubjectRetrieveController.class)
public class SubjectRetrieveControllerTest {
    @Autowired
	private MockMvc mockMvc;
	  
	private Subject sbj1 = new Subject();
	private Subject sbj2 = new Subject();

	@BeforeEach
	public void setup(){
        User usr = mock(User.class);
		LoginSystem.getInstance().setUserLogged(usr);
        SubjectRegistration sReg = SubjectRegistration.getInstance();
		sbj1.setCode("4646A");   
        sbj1.setName("TCC");
		sbj1.setSchedule("AB");
		sbj1.setCode("4747B");   
        sbj1.setName("ALEST");
		sbj1.setSchedule("CD");
		sReg.add(sbj1);
        sReg.add(sbj2);
	}

	@Test
	public void retrieveSubjectTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/student/allstudent")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"code\": \"4646A\",\"name\": \"TCC\",\"schedule\": \"AB\"},{\"code\": \"4747B\",\"name\": \"ALEST\",\"schedule\": \"CD\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}