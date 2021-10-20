package com.example.springboot;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HelloController {
    
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

	// @GetMapping("/nasa")     //testing default set to current date
	// public String nasa() {
	// 	return "nasa";	
	// }

	
	 @GetMapping("/nasa")

	public String nasa (@RequestParam (name= "date", required=false) String date, Model model) {

	 if(date == null){ //sets default to (Current) today's date
		 LocalDate today = LocalDate.now();
		 date=(today.toString());
	    }
		 else{
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate inputDay = LocalDate.parse(date,formatter);
		  date=(inputDay.toString());
		 }
			 
	     model.addAttribute("date",  date);
	  	return "nasa";
	  }
} 


