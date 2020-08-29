package com.mastercard.bookstore.app.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.Filter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import org.hamcrest.Matchers;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.mastercard.bookstore.app.controller.BookStoreController;
import com.mastercard.bookstore.app.model.Book;
import com.mastercard.bookstore.app.repository.BookRepository;
import com.mastercard.bookstore.app.service.BookStoreService;
import com.mastercard.bookstore.app.util.BookStoreUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreTest {

	// getting the instance of the BookStoreUtil class
	BookStoreUtil util = BookStoreUtil.getInstance();

	private MockMvc mockMvc;

	@Mock
	private BookStoreService bookStoreService;

	@InjectMocks
	private BookStoreController bookStoreController;
	
	@MockBean
	private BookRepository repository;
	
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookStoreController).build();
	}

	@Test
	public void test_get_all_success() throws Exception {

		List<Book> books = new ArrayList<Book>();

		Book b1 = new Book(1, "AThe Testaments", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019"));
		Book b2 = new Book(2, "BStamements", "Fiction", "Margaret Atwood", util.convertStringToDate("21/06/2019"));

		books.add(b1);
		books.add(b2);

		Map<String, Object> response = new HashMap<>();

		response.put("books", books);
		response.put("currentPage", 0);
		response.put("totalItems", 10);
		response.put("totalPages", 2);

		when(bookStoreService.getAllBooks(0, 5, "id")).thenReturn(response);
		mockMvc.perform(get("/books")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(jsonPath("$.totalItems", Matchers.is(10)))
				.andExpect(jsonPath("$.books", Matchers.hasSize(2)))
				.andExpect(status().isOk());
		verify(bookStoreService, times(1)).getAllBooks(0, 5, "id");
		verifyNoMoreInteractions(bookStoreService);
	}

	@Test
	public void test_get_by_id_success() throws Exception {
		
		
	}
	
	@Test
	public void test_delete_user_success() throws Exception {
		Book book = new Book(1, "AThe Testaments", "Fiction", "Margaret Atwood",
				util.convertStringToDate("21/06/2019"));
		when(bookStoreService.getBookById(book.getId())).thenReturn(Optional.of(book));
		doNothing().when(bookStoreService).deleteBookById(book.getId());
		 mockMvc.perform(
		            delete("/books/{id}", book.getId()))
		            .andExpect(status().isOk());
		     verify(bookStoreService, times(1)).getBookById(book.getId());
		    verify(bookStoreService, times(1)).deleteBookById(book.getId());
		verifyNoMoreInteractions(bookStoreService);
	}

	

}