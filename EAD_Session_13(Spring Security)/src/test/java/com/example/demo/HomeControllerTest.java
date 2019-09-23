package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * The Class HomeControllerTest is test class which uses the mockMvc to test its GET methods .
 * 
 * @author Aman Gautam
 * 
 * Dated: 23/9/19
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class HomeControllerTest {


	@Autowired
	private MockMvc mvc;

	/**
	 * Test should return string when searched by get method at "/index".
	 *
	 * @throws Exception
	 */
	@Test
	public void testShouldReturnStringWhenSearchedByGetMethod_atIndex() throws Exception {
		this.mvc.perform(get("/index")).andExpect(status().isOk());
	}
	
	/**
	 * Test should return string when searched by get method at "/showStudent".
	 *
	 * @throws Exception 
	 */
	@Test
	public void testShouldReturnStringWhenSearchedByGetMethod_atShowStudent() throws Exception {
		this.mvc.perform(get("/showStudent")).andExpect(status().isOk());
	}
}
