package com.springboot.course.courseapi.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@PostMapping()
	public void createTopic(@RequestBody Topic topic) {
		topicService.createTopic(topic);
	}

	@GetMapping()
	public List<Topic> getTopics() {
		return topicService.getAllTopics();
	}

	@GetMapping("/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@PutMapping("/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}

	@DeleteMapping("/{id}")
	public void removeTopic(@PathVariable String id) {
		topicService.removeTopic(id);
	}

}