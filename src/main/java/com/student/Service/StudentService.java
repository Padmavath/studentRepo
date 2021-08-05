package com.student.Service;

import java.util.List;

import com.student.bean.StudentBean;

public interface StudentService {
	List<StudentBean> getallstudent();
	
	void createStudent(StudentBean studentbean);
	
	void updateStudent(StudentBean studenbean);
	
	void deleteStudentById(Long Id);

	StudentBean getStudentById(Long Id);
}
