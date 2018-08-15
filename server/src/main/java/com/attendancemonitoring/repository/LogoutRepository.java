package com.attendancemonitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendancemonitoring.entity.Logout;

public interface LogoutRepository extends JpaRepository<Logout, Integer> {

}
