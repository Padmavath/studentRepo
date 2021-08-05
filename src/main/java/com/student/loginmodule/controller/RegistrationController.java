package com.student.loginmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.loginmodule.entity.UserEntity;
import com.student.loginmodule.service.RegistrationService;

public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@RequestMapping("getstudentbyidpage/{id}")
	public ModelAndView getstudentById(@PathVariable Long id){
		ModelAndView mav=new ModelAndView();
		UserEntity userEntity=registrationService.getStudentById(id);
	return mav;
}
}
