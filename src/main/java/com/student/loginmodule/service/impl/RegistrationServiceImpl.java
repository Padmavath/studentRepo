package com.student.loginmodule.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.student.bean.StudentBean;
import com.student.entity.StudentEntity;
import com.student.loginmodule.entity.UserEntity;
import com.student.loginmodule.repository.RegistrationRepository;
import com.student.loginmodule.service.RegistrationService;
import com.student.reposetry.StudentEntityReposetry;

public class RegistrationServiceImpl implements RegistrationService {
	   private RegistrationRepository registrationRepository;

	@Override
	public List<UserEntity> getallstudent() {
		List<UserEntity> studentList=new ArrayList<>();
		List<UserEntity> studentEntity=registrationRepository.findAll();
		for (UserEntity userEntity : studentEntity) {
			UserEntity userEntity1=new UserEntity();
			userEntity.setId(userEntity1.getId());
			userEntity.setName(userEntity1.getName());
			userEntity.setEmail(userEntity1.getEmail());
			userEntity.setPassword(userEntity1.getPassword());
			
		}
		return studentList;
	}

	@Override
	public void createStudent(UserEntity userEntity) {
		UserEntity userEntity1=new UserEntity();
		userEntity.setId(userEntity1.getId());
		userEntity.setName(userEntity1.getName());
		userEntity.setEmail(userEntity1.getEmail());
		userEntity.setPassword(userEntity1.getPassword());
		registrationRepository.save(userEntity);
	}

	@Override
	public void updateStudent(UserEntity userEntity) {
		if(registrationRepository.existsById(userEntity.getId())){
			userEntity.setId(userEntity.getId());
			userEntity.setName(userEntity.getName());
			userEntity.setEmail(userEntity.getEmail());
			userEntity.setPassword(userEntity.getPassword());
			registrationRepository.save(userEntity);
		}
	}

	@Override
	public void deleteStudentById(Long Id) {
		registrationRepository.deleteById(Id);		
	}

	@Override
	public UserEntity getStudentById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
