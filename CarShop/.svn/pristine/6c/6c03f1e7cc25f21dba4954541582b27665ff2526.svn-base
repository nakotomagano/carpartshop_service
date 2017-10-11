package com.techdata.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Login controller is responsable for Login of users and 
 * for registering new users.
 * */
@Controller
public class LoginController {

	String message = "Welcome to Spring MVC!";

	/**
	 * Login method is called from index.jsp form Login. 
	 * Requested mapping parameter is activated when Login form is submited (action ="/login");
	 * If everything is ok page will let you on logged page. It is not yet implemented any 
	 * connection to web service Car Shop. So dummy data will work fine.  
	 * */
	@RequestMapping("/login")
	public ModelAndView showMessage(){
	    // Code below is used for sending data thorugh url.  
		//		@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
       
		ModelAndView mv = new ModelAndView("logged");
		mv.addObject("message", message);
		//mv.addObject("name", name);
		return mv;
	}

}
