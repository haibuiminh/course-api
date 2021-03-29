package com.springboot.course.courseapi.persistence.event;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

public final class PaginatedResultsRetrievedEvent<T extends Serializable> extends ApplicationEvent {

	private final UriComponentsBuilder uriBuilder;

	private final HttpServletResponse response;

	private final int page;

	private final int totalPages;

	private final int pageSize;

	public PaginatedResultsRetrievedEvent(final Class<T> clazz, final UriComponentsBuilder uriBuilderToSet,
			final HttpServletResponse responseToSet, final int pageToSet, final int totalPagesToSet,
			final int pageSizeToSet) {
		super(clazz);

		this.uriBuilder = uriBuilderToSet;
		this.response = responseToSet;
		this.page = pageToSet;
		this.totalPages = totalPagesToSet;
		this.pageSize = pageSizeToSet;
	}

	public UriComponentsBuilder getUriBuilder() {
		return uriBuilder;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public int getPage() {
		return page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * The object on which the Event initially occurred.
	 * @return The object on which the Event initially occurred.
	 */
	@SuppressWarnings("unchecked")
	public final Class<T> getClazz() {
		return (Class<T>) getSource();
	}

}