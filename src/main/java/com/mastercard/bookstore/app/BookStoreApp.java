package com.mastercard.bookstore.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mastercard.bookstore.app.model.Book;
import com.mastercard.bookstore.app.repository.BookRepository;
import com.mastercard.bookstore.app.util.BookStoreUtil;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {BookRepository.class})
public class BookStoreApp implements CommandLineRunner {

	@Autowired
	BookRepository bookRepo;

	// getting the instance of the BookStoreUtil class
	BookStoreUtil util = BookStoreUtil.getInstance();

	public static void main(String[] args) {

		SpringApplication.run(BookStoreApp.class, args);

	}
	//overriding the run method to persist all the entries in the H2 Database
	@Override
	public void run(String... args) throws Exception {

		bookRepo.save(new Book(1, "The Lord of the Rings", "Fiction", "J.R.R. Tolkien", util.convertStringToDate("20/08/2010")));
		bookRepo.save(new Book(2, "Peace Talks", "Fantasy", "Jim Butcher", util.convertStringToDate("14/07/2020")));
		bookRepo.save(new Book(3, "The Achemist", "Classic", "Paulo Ceolho", util.convertStringToDate("15/04/2014")));
		bookRepo.save(new Book(4, "True Love", "Novel", "Sarah Gerrard", util.convertStringToDate("07/07/2020")));
		bookRepo.save(new Book(5, "American Dirst", "Novel", "Jeannie Cummins", util.convertStringToDate("21/01/2020")));
		bookRepo.save(new Book(6, "Inheritors", "Literature", "Asako Serizawa", util.convertStringToDate("14/07/2020")));
		bookRepo.save(new Book(7, "Axioms End", "Science Fiction", "Lindsay Ellis", util.convertStringToDate("21/07/2020")));
		bookRepo.save(new Book(8, "Shielded", "Fantasy", " KayLynn Flanders", util.convertStringToDate("21/07/2020")));
		bookRepo.save(new Book(9, "Want", "Literary Fiction", " Lynn Steger Strong", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(10, "Atomic Love", "War", "Jennie Fields", util.convertStringToDate("05/08/2020")));	
	}

}
