package syksy23.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DemoController {
	
	@RequestMapping("/main")
	@ResponseBody
	public String ShowMainPage() {
		return "Tämä on autokaupan pääsivu";		
			}
	@RequestMapping("moi")
	@ResponseBody
	public String sayHello(@RequestParam (name="nimesi", required=false, defaultValue="Veeti") String nimi) {
		return "Hei " + nimi;		
	}
	@RequestMapping("moi2")
	@ResponseBody
	public String sayHello2(@RequestParam (name="nimesi", required=false, defaultValue="Veeti") String nimi, 
			@RequestParam (name="ika", required=false, defaultValue="22") int age ) {
		return "Hei " + nimi + ", " + age + " vuotta";
}
}