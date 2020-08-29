package com.mastercard.bookstore.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mastercard.bookstore.app.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
	

}
