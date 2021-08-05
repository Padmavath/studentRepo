package com.student.loginmodule.service;

import java.util.List;

import com.student.bean.StudentBean;
import com.student.loginmodule.entity.UserEntity;

public interface RegistrationService {
List<UserEntity> getallstudent();
	
	void createStudent(UserEntity userEntity);
	
	void updateStudent(UserEntity userEntity);
	
	void deleteStudentById(Long Id);

	UserEntity getStudentById(Long Id);
}
