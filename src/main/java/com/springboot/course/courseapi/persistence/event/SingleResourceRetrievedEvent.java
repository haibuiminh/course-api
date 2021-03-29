package com.springboot.course.courseapi.persistence.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class SingleResourceRetrievedEvent extends ApplicationEvent {

	private final HttpServletResponse response;

	public SingleResourceRetrievedEvent(final Object source, final HttpServletResponse response) {
		super(source);

		this.response = response;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

}