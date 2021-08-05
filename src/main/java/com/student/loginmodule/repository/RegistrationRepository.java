package com.student.loginmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.loginmodule.entity.UserEntity;

public interface RegistrationRepository extends JpaRepository<UserEntity, Long>  {

}
