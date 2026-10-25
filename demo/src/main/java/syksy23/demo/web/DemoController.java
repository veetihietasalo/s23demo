package syksy23.demo.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// The answers are plain text. Without produces = text/plain a browser gets
// them as text/html, and /moi?nimesi=<script>... runs in the page.
@Controller
public class DemoController {

	@GetMapping(value = "/main", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ShowMainPage() {
		return "Tämä on autokaupan pääsivu";
	}

	@GetMapping(value = "/moi", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String sayHello(@RequestParam(name = "nimesi", required = false, defaultValue = "Veeti") String nimi) {
		return "Hei " + nimi;
	}

	@GetMapping(value = "/moi2", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String sayHello2(@RequestParam(name = "nimesi", required = false, defaultValue = "Veeti") String nimi,
			@RequestParam(name = "ika", required = false, defaultValue = "22") int age) {
		return "Hei " + nimi + ", " + age + " vuotta";
	}
}
