package com.springboot.course.courseapi.service;

import java.util.ArrayList;
import java.util.List;

import com.springboot.course.courseapi.model.Post;
import com.springboot.course.courseapi.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> getPostsList() {
		List<Post> posts = new ArrayList<>();
		this.postRepository.findAll().forEach(posts::add);
		return posts;
	}

	@Override
	public void updatePost(Post post) {
		postRepository.save(post);
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findById(id).get();
	}

}