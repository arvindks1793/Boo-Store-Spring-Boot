package com.mastercard.bookstore.app.exception;

//a class to handle book(resource) not found exception
public class BookNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {

		super();
	}

	public BookNotFoundException(String message) {

		super(message);
	}
}
