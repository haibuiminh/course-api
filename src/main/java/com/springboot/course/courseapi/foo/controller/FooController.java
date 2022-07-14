package com.springboot.course.courseapi.foo.controller;

import java.util.List;

import com.springboot.course.courseapi.foo.model.Foo;
import com.springboot.course.courseapi.foo.service.IFooService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/foos")
public class FooController {

  @Autowired
  private IFooService service;

  public FooController(IFooService service) {
    super();
    this.service = service;
  }

  @GetMapping
  public List<Foo> findAll() {
    return service.findAll();
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") final Long id) {
    service.deleteById(id);
  }

  
}