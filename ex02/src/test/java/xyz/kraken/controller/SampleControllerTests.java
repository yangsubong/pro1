package xyz.kraken.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml ","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j//로그
@WebAppConfiguration
public class SampleControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.standaloneSetup(ctx).build();
	}
	
	@Test
	public void testConver() throws Exception{
		Ticket ticket = new Ticket();
		ticket.setTno(123);
		ticket.setOwner("bbb");
		ticket.setGrade("aaa");
		
		String jsonStr = new Gson().toJson(ticket);
		log.info(jsonStr);
		
		mvc.perform(post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr)).andExpect(status().is(200));
			
	}
	
	
}
