package com.springboot.course.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("springboot", "Learn Java Spring Boot", "This is description of Learn Java Spring boot topic"),
			new Topic("nodejs", "Learn Java Node JS",
					"This is description of Learn JavaScript backend with Nodejs topic"),
			new Topic("Nestjs", "Learn NestJS Framework of NodeJS", "This is description of Learn NestJS topic")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public void createTopic(Topic topic) {
		topics.add(topic);
	}

	public Topic getTopic(String id) {
		return (Topic) topics.stream().filter(t -> t.getId().equals(id));
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void removeTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}