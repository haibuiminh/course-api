package com.springboot.course.courseapi.persistence.dao;

import com.springboot.course.courseapi.persistence.model.Foo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFooDao extends JpaRepository<Foo, Long> {

}