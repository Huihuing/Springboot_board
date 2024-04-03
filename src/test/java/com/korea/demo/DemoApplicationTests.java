package com.korea.demo;

import com.korea.demo.domain.Article;
import com.korea.demo.domain.member;
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

	@Test
	void contextLoads(){

		member member = new member(1, "hong123", "1234", "홍길동", "");
		Article article = new Article(1, "제목1", "내용1", 0, "");

		article.setmemberId(1); // 1번 회원이 작성했다는 의미

		// 1번 회원의 이름을 찾아야 함. => member sql 처리를 위한 코드를 작성해야 한다.


		//article.setMemberId
//		@DisplayName("list 기능 테스트")
//		void t1 () throws Exception {
//			mockMvc.perform(get("/hello"))
//					.andExpect(status().isOk())
//					.andExpect(content().string("hello, world"));
//		}

	}
}