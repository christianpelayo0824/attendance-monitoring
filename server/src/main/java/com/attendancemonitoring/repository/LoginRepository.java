package com.attendancemonitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendancemonitoring.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
