package com.attendancemonitoring.sevices;

import java.util.List;
import java.util.Optional;

import com.attendancemonitoring.entity.Login;

public interface LoginServices {

	public List<Login> getAllLoginData();

	public void createLoginData(Login login);

	public void updateLoginData(Login login);

	public Optional<Login> getLoginDataById(int loginId);
	
	public int countLoginData();
}
