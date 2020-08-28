package com.mastercard.bookstore.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {

	// Default Constructor
	public Book() {

	}

	// parameterized constructor for initializing values on application load
	public Book(int id, String title, String category, String authorName, Date publicationDate) {

		this.id = id;
		this.title = title;
		this.category = category;
		this.authorName = authorName;
		this.publicationDate = publicationDate;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@Column(name = "Title")
	private String title;
	@Column(name = "Category")
	private String category;
	@Column(name = "Author_Name")
	private String authorName;
	@Column(name = "Publication_Date")
	private Date publicationDate;

}
