package com.student.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.Service.StudentService;
import com.student.bean.StudentBean;
@RestController
@RequestMapping(value="api/student/")
public class StudentRestController {
	
	private StudentService studentService;
	//@Autowired
	public StudentRestController(StudentService studentService) {
		
		this.studentService = studentService;
	}
	@GetMapping(value="getstudentbyid/{id}")
	//@RequestMapping(value="getstudentbyid/{id}",method = RequestMethod.GET,produces = { "application/xml", "text/xml" })
	public StudentBean getstudentById(@PathVariable Long id){
		StudentBean student=studentService.getStudentById(id);
			return student;
}
	@DeleteMapping(value="deletestudent/{id}")
	public String deleteStudent(@PathVariable Long id){
		studentService.deleteStudentById(id);
		return "Delete Successfully";
}
	@GetMapping(value="getallstudent")
	public List<StudentBean> getAllStudent(){
		List<StudentBean> studentList =studentService.getallstudent();
		return studentList;
	}
	@PostMapping(value="createstudent")
	public String createStudent(@RequestBody StudentBean studentBean){
		studentService.createStudent(studentBean);
		return "Create Successfully";
	}
	@PutMapping(value="updatestudent")
	public String updateStudent(@RequestBody StudentBean studentBean){
		studentService.updateStudent(studentBean);
		return "Update Successfully";
	}
}
