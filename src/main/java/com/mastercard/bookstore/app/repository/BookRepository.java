package com.mastercard.bookstore.app.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.mastercard.bookstore.app.model.Book;


public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
	
	 
}
