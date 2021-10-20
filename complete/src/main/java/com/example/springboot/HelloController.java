package com.example.springboot;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// @GetMapping("/nasa").     //testing default set to current date
	// public String nasa() {
	// 	return "nasa";	
	// }

	
	
	 @GetMapping("/nasa")

	 public String nasa (@RequestParam (name= "date", required=false) Date date, Model model) throws ParseException  {

	 	if(date == null){ //sets default to (Current) today's date
			 Date todayDate= new Date();
			 date= todayDate;
		 }
			 else{
 				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		   		String dayAsString = sdf.format(date); // formats date received to string in desired format using sdf 
				Date dateIn = sdf.parse(dayAsString);        //parses string after format/ assigns to dateIn
				date=dateIn;  //returns date with desired format
	 	}
		 
	 	model.addAttribute("date",  date);
	 	return "nasa";
	 }
} 


