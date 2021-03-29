package com.springboot.course.courseapi.persistence.service;

import com.springboot.course.courseapi.persistence.IOperations;
import com.springboot.course.courseapi.persistence.model.Foo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFooService extends IOperations<Foo> {

	Page<Foo> findPaginated(Pageable pageable);

}