// package com.springboot.course.courseapi.service;

// import com.springboot.course.courseapi.model.Preference;
// import com.springboot.course.courseapi.model.User;

// import org.springframework.stereotype.Service;

// @Service
// public class UserService implements IUserService {

// 	@Override
// 	public User getCurrentUser() {
// 		Preference preference = new Preference();
// 		preference.setId(1L);
// 		preference.setTimezone("Asia/Calcutta");

// 		User user = new User();
// 		user.setId(1L);
// 		user.setName("Hai Bui");
// 		user.setPreference(preference);

// 		return user;
// 	}

// }