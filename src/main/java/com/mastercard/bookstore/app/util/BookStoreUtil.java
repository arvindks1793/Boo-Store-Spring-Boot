package com.mastercard.bookstore.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//creating a singleton pattern for Util class
public class BookStoreUtil {

	// creating an object of the Util class
	private static final BookStoreUtil util = new BookStoreUtil();

	// making the constructor private such that this class cannot instantiated
	private BookStoreUtil() {

	}

	// Get the only instance available
	public static BookStoreUtil getInstance() {

		return util;
	}

	// converts a String to Date format
	public Date convertStringToDate(String stringDate) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date;

		try {

			date = formatter.parse(stringDate);

		} catch (ParseException e) {

			e.printStackTrace();
			throw e;

		}
		return date;
	}

}
