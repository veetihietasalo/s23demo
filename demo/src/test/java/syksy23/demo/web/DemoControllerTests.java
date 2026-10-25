package syksy23.demo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DemoController.class)
class DemoControllerTests {

	private static final String BROWSER_ACCEPT = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";

	@Autowired
	private MockMvc mockMvc;

	@Test
	void moiGreetsByName() throws Exception {
		mockMvc.perform(get("/moi").param("nimesi", "Anna"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hei Anna"));
	}

	@Test
	void moi2UsesDefaults() throws Exception {
		mockMvc.perform(get("/moi2"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hei Veeti, 22 vuotta"));
	}

	@Test
	void nameIsServedAsPlainTextToBrowsers() throws Exception {
		mockMvc.perform(get("/moi").param("nimesi", "<script>alert(1)</script>").header("Accept", BROWSER_ACCEPT))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
		mockMvc.perform(get("/moi2").param("nimesi", "<b>x</b>").header("Accept", BROWSER_ACCEPT))
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
	}

}
