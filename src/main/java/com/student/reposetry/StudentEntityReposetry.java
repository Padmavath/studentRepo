package com.student.reposetry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;
@Repository
public interface StudentEntityReposetry extends JpaRepository<StudentEntity, Long> {
	//@Query("Select * FROM  StudentEntity WHERE sname=? AND semail=?")
//public List<StudentEntity> getStudentByNameAndEmailId(String name,String emailId);
}
