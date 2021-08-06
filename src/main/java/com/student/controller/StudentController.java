package com.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.Service.StudentService;
import com.student.bean.StudentBean;

@Controller
public class StudentController {
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;
	@RequestMapping("getstudentbyidpage/{id}")
	public ModelAndView getstudentById(@PathVariable Long id){
		ModelAndView mav=new ModelAndView();
		
		StudentBean student=studentService.getStudentById(id);
		if(student !=null){
			mav.addObject("id",student.getId());
			mav.addObject("name",student.getName());
			mav.addObject("email",student.getEmail());
			mav.addObject("password",student.getPassword());
			mav.addObject("massege", "data found succesfully ");

}
		else{
			mav.addObject("massege", "data not found fot id "+id);
		}
		mav.setViewName("getStudentbYid");
		return mav;
	

	}
	 @GetMapping("/createstudent")
	    public String addBookView(Model model) {
		 logger.debug("create a student start debug");
		 logger.info("create a student start info");
		 logger.warn("create a student startwarning");
		 logger.error("create a student start error");
		  model.addAttribute("studentBean", new StudentBean());
	        logger.info("create a student end");
	        return "CreateStudent";
	    }
		
@PostMapping(value="createstudent")
public ModelAndView createStudent(@ModelAttribute("studentBean") StudentBean studentBean){
	logger.info("create a student post method start");
	logger.info("StudentBean=  "+studentBean);
	ModelAndView mav=new ModelAndView();
	studentService.createStudent(studentBean);
	mav.addObject("SuccessMessage", true);
	mav.setViewName("CreateStudent");
	logger.info("create a student post method end");

	return mav;


	}
@GetMapping(value="deletestudent/{id}")
//@DeleteMapping(value="deletestudent/{id}")
public ModelAndView deleteStudent(@PathVariable Long id){
	ModelAndView mav=new ModelAndView("redirect:" + "/getallstudent");
	studentService.deleteStudentById(id);
	//mav=getAllStudent();
	//return new ModelAndView("redirect:" + projectUrl);
	return mav;
	
	
}
@GetMapping("updatestudent/{id}")
public ModelAndView updatestudentById(@PathVariable Long id){
	ModelAndView mav=new ModelAndView();
	
	StudentBean student=studentService.getStudentById(id);
	
	if(student !=null){
		mav.addObject("id",student.getId());
		mav.addObject("name",student.getName());
		mav.addObject("email",student.getEmail());
		mav.addObject("password",student.getPassword());
		mav.addObject("massege", "data found succesfully ");

}
	else{
		mav.addObject("massege", "data not found fot id "+id);
	}
	mav.addObject("xyz", "updatestudent");
	 mav.addObject("studentBean", new StudentBean());
	mav.setViewName("updatestudent");
	return mav;


}
@PostMapping(value="updatestudent",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public ModelAndView updateStudent(@ModelAttribute StudentBean studentBean){
	ModelAndView mav=new ModelAndView();
	studentService.updateStudent(studentBean);
	if(studentBean !=null){
		mav.addObject("id",studentBean.getId());
		mav.addObject("name",studentBean.getName());
		mav.addObject("email",studentBean.getEmail());
		mav.addObject("password",studentBean.getPassword());
		mav.addObject("massege", "data found succesfully ");

}
	else{
		mav.addObject("massege", "data not found fot id ");
	}
	mav.setViewName("updatestudent");
	return mav;
	
}
@GetMapping(value="getallstudent")
public ModelAndView getAllStudent(){
	ModelAndView mav=new ModelAndView();
	List<StudentBean> studentList=studentService.getallstudent();
	mav.addObject("studentList", studentList);
	mav.setViewName("getallstudent");
	return mav;
}
@RequestMapping("/")
public ModelAndView getHomepage(){
	ModelAndView mav=new ModelAndView();
	mav.setViewName("Home");
	return mav;
	
}

}

	