package com.mastercard.bookstore.app.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.bookstore.app.exception.BookListNotFoundException;
import com.mastercard.bookstore.app.exception.BookNotFoundException;
import com.mastercard.bookstore.app.model.Book;
import com.mastercard.bookstore.app.service.BookStoreService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookStoreController {

	@Autowired
	BookStoreService service;

	// method to fetch all the books from the DB
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllBooks(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy
			,@RequestParam(defaultValue = "asc") String sortDirection)
			throws IOException {

		Map<String, Object> map = service.getAllBooks(pageNo, pageSize, sortBy, sortDirection);
		
		if(map.isEmpty()) {
			
			throw new BookListNotFoundException("Books List unable to be fetched");
		}

		return new ResponseEntity<Map<String, Object>>(map, new HttpHeaders(), HttpStatus.OK);

	}

	// method to delete a book based on id
	@RequestMapping(value = "books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBookById(@PathVariable("id") int id) {
		
		Optional<Book> book = service.getBookById(id);
		if (book != null && book.isPresent()) {
			service.deleteBookById(id);
			return new ResponseEntity<Book>(HttpStatus.OK);
		} else {
			throw new BookNotFoundException("Book with id" + " " + id + " " + "is not found");
		}

	}

	// method to fetch a book from DB based on id
	@RequestMapping(value = "books/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {

		Optional<Book> book = service.getBookById(id);

		if (book != null && book.isPresent()) {

			return ResponseEntity.ok(book.get());

		} else {

			throw new BookNotFoundException("Book with id" + " " + id + " " + "is not found");

		}

	}

}
