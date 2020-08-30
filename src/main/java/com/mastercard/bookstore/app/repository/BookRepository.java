package com.mastercard.bookstore.app.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mastercard.bookstore.app.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
	
	 Page<Book> findAll(Pageable pageable);
}
