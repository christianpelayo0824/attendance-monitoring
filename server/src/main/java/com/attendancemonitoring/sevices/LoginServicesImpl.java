package com.attendancemonitoring.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendancemonitoring.entity.Login;
import com.attendancemonitoring.repository.LoginRepository;


@Service
public class LoginServicesImpl implements LoginServices {

	@Autowired
	private LoginRepository loginRepo;

	@Override
	public List<Login> getAllLoginData() {
		return loginRepo.findAll();
	}

	@Override
	public void createLoginData(Login login) {
		loginRepo.save(login);
	}

	@Override
	public void updateLoginData(Login login) {
		loginRepo.save(login);

	}

	@Override
	public Optional<Login> getLoginDataById(int loginId) {
		return loginRepo.findById(loginId);
	}

	@Override
	public int countLoginData() {
		return (int) loginRepo.count();
	}

}
