package com.korea.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TboardApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test {
		@DisplayName("list 기능 테스트")
		void t1 () throws Exception {
			mockMvc.perform(get("/hello"))
					.andExpect(status().isOk())
					.andExpect(content().string("hello, world"));
		}

	}
}