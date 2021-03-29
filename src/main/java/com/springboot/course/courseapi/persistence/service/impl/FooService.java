package com.springboot.course.courseapi.persistence.service.impl;

import com.springboot.course.courseapi.persistence.dao.IFooDao;
import com.springboot.course.courseapi.persistence.model.Foo;
import com.springboot.course.courseapi.persistence.service.IFooService;
import com.springboot.course.courseapi.persistence.service.common.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FooService extends AbstractService<Foo> implements IFooService {

	@Autowired
	private IFooDao dao;

	public FooService() {
		super();
	}

	@Override
	public Page<Foo> findPaginated(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	protected PagingAndSortingRepository<Foo, Long> getDao() {
		return dao;
	}

}