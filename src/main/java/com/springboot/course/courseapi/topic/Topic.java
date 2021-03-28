package com.springboot.course.courseapi.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
	private String id;

	private String name;

	private String description;

	public Topic(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Topic() {

	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

}