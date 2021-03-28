package com.springboot.course.courseapi.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic createTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public Topic getTopic(String id) {
		try {
			return topicRepository.findById(id).get();
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Not found topic with id = %s", id));
		}
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void removeTopic(String id) {
		topicRepository.deleteById(id);
	}

}