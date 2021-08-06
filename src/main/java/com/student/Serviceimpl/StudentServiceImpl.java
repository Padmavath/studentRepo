package com.student.Serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.student.Service.StudentService;
import com.student.bean.StudentBean;
import com.student.controller.StudentController;
import com.student.entity.StudentEntity;
import com.student.reposetry.StudentEntityReposetry;
@Service
//@Component
public class StudentServiceImpl implements StudentService {
	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
   private StudentEntityReposetry studentEntityReposetry;
	@Override
	public List<StudentBean> getallstudent() {
		logger.info("create a student post method start");
		List<StudentBean> studentList=new ArrayList<>();
		List<StudentEntity> studentEntity=studentEntityReposetry.findAll();
		for (StudentEntity studentEntity2 : studentEntity) {
			StudentBean studentBean=new StudentBean();
			studentBean.setId(studentEntity2.getId());
			studentBean.setName(studentEntity2.getName());
			studentBean.setEmail(studentEntity2.getEmail());
			studentBean.setPassword(studentEntity2.getPassword());
			studentList.add(studentBean);
		}

		return studentList;
	}

	@Override
	public void createStudent(StudentBean studentbean) {
		logger.info("create a student post method start");
		StudentEntity studentEntity=new StudentEntity();
			studentEntity.setId(studentbean.getId());
			studentEntity.setName(studentbean.getName());
			studentEntity.setEmail(studentbean.getEmail());
			studentEntity.setPassword(studentbean.getPassword());
			studentEntityReposetry.save(studentEntity);
			logger.info("create a student post method end");


		}
	

	@Override
	public void updateStudent(StudentBean studenbean) {
		if(studentEntityReposetry.existsById(studenbean.getId())){
			StudentEntity studentEntity=studentEntityReposetry.findById(studenbean.getId()).get();
			studentEntity.setName(studenbean.getName());
			studentEntity.setEmail(studenbean.getEmail());
			studentEntity.setPassword(studenbean.getPassword());
			studentEntityReposetry.save(studentEntity);

		}
		
	}

	@Override
	public void deleteStudentById(Long Id) {
		studentEntityReposetry.deleteById(Id);
	}

	@Override
	public StudentBean getStudentById(Long Id) {
		StudentBean studentBean1=null;
		if(studentEntityReposetry.existsById(Id)){
			StudentEntity studentEntyity =studentEntityReposetry.findById(Id).get();
		    studentBean1=new StudentBean();
			studentBean1.setId(studentEntyity.getId());
			studentBean1.setName(studentEntyity.getName());
			studentBean1.setEmail(studentEntyity.getEmail());
			studentBean1.setPassword(studentEntyity.getPassword());
		}
		
		
		return studentBean1;
	}

}
