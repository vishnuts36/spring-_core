package com.luv2code.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read data and add that to model.
	@RequestMapping("/processFormVersionTwo")
	public String LetsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter form html form
		
		String theName = request.getParameter("studentname");
		
		//convert the data to capital letter
		 theName = theName.toUpperCase();
		
		//create message
		 String result = "Yoo!! -->"+theName;
		
		//add the message to the model
		 model.addAttribute("msg", result);
		
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentname") String theName, Model model) {
		
		 theName = theName.toUpperCase();
		
		//create message
		 String result = "Hey My Friend from V3!! -->"+theName;
		
		//add the message to the model
		 model.addAttribute("msg", result);
		
		
		return "helloworld";
	}

}
