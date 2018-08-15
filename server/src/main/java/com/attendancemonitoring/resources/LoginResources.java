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

import com.attendancemonitoring.entity.Login;
import com.attendancemonitoring.sevices.LoginServices;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class LoginResources {

	@Autowired
	private LoginServices loginServices;

	@GetMapping(value = "/getAllLoginData")
	public List<Login> getAllLoginData() {
		return loginServices.getAllLoginData();
	}

	@GetMapping(value = "/getLoginDataById/{loginId}")
	public Optional<Login> getLoginDataById(@PathVariable("loginId") final int loginId) {
		return loginServices.getLoginDataById(loginId);
	}

	@PostMapping(value = "/createLoginData", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createLoginData(@RequestBody Login login) {

		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		GregorianCalendar calendar = new GregorianCalendar();

		Login loginSub = new Login();

		String state = "";

		if (calendar.get(Calendar.AM_PM) == 0) {
			state = "AM";
		} else {
			state = "PM";
		}

		loginSub.setFirstname(login.getFirstname());
		loginSub.setLastname(login.getLastname());
		loginSub.setType(login.getType());
		loginSub.setTimeDate(months[calendar.get(Calendar.MONTH)] + " : " + calendar.get(Calendar.DATE) + " : "
				+ calendar.get(Calendar.YEAR) + " / " + calendar.get(Calendar.HOUR) + " : "
				+ calendar.get(Calendar.MINUTE) + " : " + calendar.get(Calendar.SECOND) + " " + state);

		loginServices.createLoginData(loginSub);
	}

	@PutMapping(value = "/updateLoginData", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateLoginData(@RequestBody Login login) {
		loginServices.updateLoginData(login);
	}

	@GetMapping(value = "/countLoginData")
	public int countLoginData() {
		return loginServices.countLoginData();
	}

}
