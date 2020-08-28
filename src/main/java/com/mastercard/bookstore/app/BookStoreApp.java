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

	@Override
	public void run(String... args) throws Exception {

		bookRepo.save(new Book(1, "AThe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(2, "BStamements", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(3, "CStamemnts", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(4, "DThe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(5, "EThe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(6, "FThe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(7, "GThe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(8, "HThe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(9, "Ihe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));
		bookRepo.save(new Book(10, "Jhe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019")));	
	}

}
