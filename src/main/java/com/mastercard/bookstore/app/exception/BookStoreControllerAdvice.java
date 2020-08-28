package com.mastercard.bookstore.app.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookStoreControllerAdvice {
	
	// method to handle resource not found exception
		@ExceptionHandler(BookNotFoundException.class)
		@ResponseStatus(value = HttpStatus.NOT_FOUND)
		public @ResponseBody ExceptionResponse handleResourceNotFound(final BookNotFoundException exception,
				final HttpServletRequest request) {
			ExceptionResponse error = new ExceptionResponse();
			error.setErrorMessage(exception.getLocalizedMessage());
			error.setRequestedURI(request.getRequestURI());
			return error;
		}
		
		
		//generic exception handler
		@ExceptionHandler(Exception.class)
		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
		public @ResponseBody ExceptionResponse handleAllException(final Exception exception,
				final HttpServletRequest request) {
			ExceptionResponse error = new ExceptionResponse();
			error.setErrorMessage(exception.getLocalizedMessage());
			error.setRequestedURI(request.getRequestURI());
			return error;
		}


}
