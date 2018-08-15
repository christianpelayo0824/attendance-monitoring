package com.attendancemonitoring.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendancemonitoring.entity.Logout;
import com.attendancemonitoring.repository.LogoutRepository;

@Service
public class LogoutServicesImpl implements LogoutServices {

	@Autowired
	private LogoutRepository logoutRepo;

	@Override
	public List<Logout> getAllLogoutData() {
		return logoutRepo.findAll();
	}

	@Override
	public void createLogoutData(Logout logout) {
		logoutRepo.save(logout);
	}

	@Override
	public void updateLogoutData(Logout logout) {
		logoutRepo.save(logout);

	}

	@Override
	public Optional<Logout> getLogoutDataById(int logoutId) {
		return logoutRepo.findById(logoutId);
	}

	@Override
	public int countLogoutData() {
		return (int) logoutRepo.count();
	}

}
