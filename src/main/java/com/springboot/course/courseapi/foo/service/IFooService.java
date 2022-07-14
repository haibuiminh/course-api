package com.springboot.course.courseapi.foo.service;

import com.springboot.course.courseapi.foo.IOperations;
import com.springboot.course.courseapi.foo.model.Foo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFooService extends IOperations<Foo> {

	Page<Foo> findPaginated(Pageable pageable);

}