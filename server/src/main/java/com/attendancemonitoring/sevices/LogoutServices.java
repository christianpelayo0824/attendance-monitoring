package com.attendancemonitoring.sevices;

import java.util.List;
import java.util.Optional;

import com.attendancemonitoring.entity.Logout;

public interface LogoutServices {

	public List<Logout> getAllLogoutData();

	public void createLogoutData(Logout logout);

	public void updateLogoutData(Logout logout);

	public Optional<Logout> getLogoutDataById(int logoutId);

	public int countLogoutData();
}
