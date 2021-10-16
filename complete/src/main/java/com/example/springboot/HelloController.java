package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class HelloController {

	// @GetMapping("/")
	// public String index() {
	// 	return "Greetings from Spring Boot!";
    // }
    
    @GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/xkcd")
	public String xkcd() {
		return "xkcd";	
	}

	//Request Parameter Method
	@GetMapping("/xkcdSpec")
	public String xkcdSpecific (@RequestParam(name="id", required=false) String id, Model model) {
		if(id== null){
			id= "200";
		}
		model.addAttribute("id", id);
		return "xkcdSpecific";
	}

	//Path variable method
	//@GetMapping("/xkcdSpec/{id}")
	//public String xkcdSpecific (@PathVariable String id, Model model) {
	//	model.addAttribute("id", id);
	//	return "xkcdSpecific";
	//}

	@GetMapping("/nasa")
	public String nasaPOD (@RequestParam(name="date", required=false) String date, Model model) {
		if(date== null){
			date= "2021-10-16";
		}
		model.addAttribute("id", id);
		return "nasaPod";
	}
}
