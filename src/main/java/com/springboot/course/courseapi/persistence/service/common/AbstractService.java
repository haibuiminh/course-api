package com.springboot.course.courseapi.persistence.service.common;

import java.io.Serializable;
import java.util.List;

import com.springboot.course.courseapi.persistence.IOperations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

	// read
	@Override
	public List<T> findAll() {
		return Lists.newArrayList(getDao().findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(long id) {
		return getDao().findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<T> findPaginated(int page, int size) {
		return getDao().findAll(PageRequest.of(page, size));
	}

	// write
	@Override
	public T create(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void deleteById(long id) {
		getDao().deleteById(id);
	}

	@Override
	public T update(T entity) {

		return getDao().save(entity);
	}

	protected abstract PagingAndSortingRepository<T, Long> getDao();

}