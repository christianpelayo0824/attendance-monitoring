package com.attendancemonitoring.resources;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendancemonitoring.entity.Logout;
import com.attendancemonitoring.sevices.LogoutServices;

@RestController
@RequestMapping(value = "/logout")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class LogoutResources {

	@Autowired
	private LogoutServices logoutServices;

	@GetMapping(value = "/getAllLogoutData")
	public List<Logout> getAllLogoutData() {
		return logoutServices.getAllLogoutData();
	}

	@GetMapping(value = "/getLogoutDataById/{logoutId}")
	public Optional<Logout> getLogoutDataById(@PathVariable("logoutId") final int logoutId) {
		return logoutServices.getLogoutDataById(logoutId);
	}

	@PostMapping(value = "/createLogoutData", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createLogoutData(@RequestBody Logout logout) {

		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		GregorianCalendar calendar = new GregorianCalendar();

		Logout logoutSub = new Logout();

		String state = "";

		if (calendar.get(Calendar.AM_PM) == 0) {
			state = "AM";
		} else {
			state = "PM";
		}

		logoutSub.setFirstname(logout.getFirstname());
		logoutSub.setLastname(logout.getLastname());
		logoutSub.setType(logout.getType());
		logoutSub.setTimeDate(months[calendar.get(Calendar.MONTH)] + " : " + calendar.get(Calendar.DATE) + " : "
				+ calendar.get(Calendar.YEAR) + " / " + calendar.get(Calendar.HOUR) + " : "
				+ calendar.get(Calendar.MINUTE) + " : " + calendar.get(Calendar.SECOND) + " " + state);

		logoutServices.createLogoutData(logoutSub);
	}

	@PutMapping(value = "/updateLogoutData", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateLogoutData(@RequestBody Logout logout) {
		logoutServices.updateLogoutData(logout);
	}

	@GetMapping(value = "/countLogoutData")
	public int countLogoutData() {
		return logoutServices.countLogoutData();
	}

}
