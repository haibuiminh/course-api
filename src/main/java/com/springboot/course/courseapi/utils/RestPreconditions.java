package com.springboot.course.courseapi.utils;

import javassist.NotFoundException;

public class RestPreconditions {

	public static <T> T checkFound(T resource) throws NotFoundException {
		if (resource == null) {
			throw new NotFoundException("Not Found data!!");
		}
		return resource;
	}

}