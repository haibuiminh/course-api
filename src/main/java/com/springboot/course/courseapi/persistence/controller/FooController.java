package com.springboot.course.courseapi.persistence.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Preconditions;
import com.springboot.course.courseapi.exception.MyResourceNotFoundException;
import com.springboot.course.courseapi.persistence.event.PaginatedResultsRetrievedEvent;
import com.springboot.course.courseapi.persistence.event.ResourceCreatedEvent;
import com.springboot.course.courseapi.persistence.event.SingleResourceRetrievedEvent;
import com.springboot.course.courseapi.persistence.model.Foo;
import com.springboot.course.courseapi.persistence.service.IFooService;
import com.springboot.util.RestPreconditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/foos")
public class FooController {
  private static final Logger logger = LoggerFactory.getLogger(FooController.class);

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Autowired
  private IFooService service;

  public FooController() {
    super();
  }

  // read - one 
  @GetMapping(value ="/{id}")
  public Foo findByID(@PathVariable("id") final Long id, final HttpServletResponse response) {
    try {
      final Foo resourceById = RestPreconditions.checkFound(service.findById(id));

      eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, response));
      return resourceById;
    } catch (MyResourceNotFoundException exc) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found!", exc);
    } 
  }

  // read - all
  @GetMapping
  public List<Foo> findAll() {
    return service.findAll();
  }
  
  @GetMapping(params = { "page", "size" })
  public List<Foo> findPaginated(@RequestParam("page") final int page, @RequestParam("size") final int size,
    final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
      final Page<Foo> resultPage = service.findPaginated(page,size);
      StringBuilder a = new StringBuilder();
      a.append("Log total page size");
      a.append(resultPage.getTotalPages());
      logger.info(a.toString());
      if (page > resultPage.getTotalPages()) {
        
        throw new MyResourceNotFoundException();
      }
      eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Foo>(Foo.class, uriBuilder, response, page, resultPage.getTotalPages(), size));
      return resultPage.getContent();
    }

  @GetMapping("/pageable")
  public List<Foo> findPaginatedWithPageable(Pageable pageable, final UriComponentsBuilder uriBuilder, 
  final HttpServletResponse response) {
    final Page<Foo> resultPage = service.findPaginated(pageable);
    logger.info(pageable.toString());
    if (pageable.getPageNumber() > resultPage.getTotalPages()) {
      throw new MyResourceNotFoundException();
    }
    eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Foo>(Foo.class, uriBuilder, response, pageable.getPageNumber(), resultPage.getTotalPages(), pageable.getPageSize()));
    return resultPage.getContent();
  }

  // write
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Foo create(@RequestBody final Foo resource, final HttpServletResponse response) {
    Preconditions.checkNotNull(resource);
    final Foo foo = service.create(resource);
    final Long idOfCreatedResource = foo.getId();

    eventPublisher.publishEvent(new ResourceCreatedEvent(this, response, idOfCreatedResource));
    return foo;
  }

  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void update(@PathVariable("id") final Long id, @RequestBody final Foo resource) {
    Preconditions.checkNotNull(resource);
    RestPreconditions.checkFound(service.findById(resource.getId()));
    service.update(resource);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") final Long id) {
    service.deleteById(id);
  }

  
}