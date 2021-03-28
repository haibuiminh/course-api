package com.springboot.course.courseapi.service;

import java.util.List;

import com.springboot.course.courseapi.model.Post;

public interface IPostService {

	public List<Post> getPostsList();

	public void updatePost(Post post);

	public Post createPost(Post post);

	public Post getPostById(Long id);

}