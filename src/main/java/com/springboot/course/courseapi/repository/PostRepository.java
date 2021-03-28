package com.springboot.course.courseapi.repository;

import com.springboot.course.courseapi.model.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}