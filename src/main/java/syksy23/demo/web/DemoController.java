package syksy23.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
    @GetMapping("/index")
    public String index() {
        return "This is the main page";
    }

    @GetMapping("/contact")
    public String contact() {
        return "This is the contact page";
    }
    @GetMapping("/hello")
    public String hello(@RequestParam String location, @RequestParam String name) {
        return "Welcome to the " + location + " " + name + "!";
    }
}