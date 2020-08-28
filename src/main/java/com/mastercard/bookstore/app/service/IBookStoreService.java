package com.mastercard.bookstore.app.service;

import java.util.Map;
import java.util.Optional;

import com.mastercard.bookstore.app.model.Book;

public interface IBookStoreService {

	Map<String, Object> getAllBooks(Integer pageNo, Integer pageSize, String sortBy);

	boolean isBookExist(int id);

	void deleteBookById(int id);

	Optional<Book> getBookById(int id);

}
