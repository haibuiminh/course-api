package com.springboot.course.courseapi.foo.dao;

import com.springboot.course.courseapi.foo.model.Foo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFooDao extends JpaRepository<Foo, Long> {

}