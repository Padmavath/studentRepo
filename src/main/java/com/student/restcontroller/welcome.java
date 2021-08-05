package com.student.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class welcome {
	//@RequestMapping("welcome")
	@GetMapping("welcome")
	@ResponseBody
	public String getmessage(){
		return "welcome world";
	}
	@RequestMapping("/welcomepage")
	public ModelAndView getpage(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","padma");
		mv.addObject("address","on srisailam");
		mv.addObject("age","21");
		mv.addObject("email","padma123@gmail.com");


		mv.setViewName("welcome");
		return mv;
	}
	
}
