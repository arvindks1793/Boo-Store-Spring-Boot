package com.mastercard.bookstore.app.exception;

public class BookListNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public BookListNotFoundException() {

		super();
	}

	public BookListNotFoundException(String message) {

		super(message);
	}
}
