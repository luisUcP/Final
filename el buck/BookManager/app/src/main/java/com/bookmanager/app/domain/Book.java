package com.bookmanager.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_BOOK")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title; 

	@Column(name = "author")
	private String author; 

	@Column(name = "genre")
	private String genre; 

	@Column(name = "publication_date")
	private String publication_date;

	@Column(name = "isbn")
	private String isbn; 

	@Column(name = "quantity_avaliable", nullable = false)
	private int quantity_avaliable;

	@Column(name = "description")
	private String description; 

	@Column(name = "cover_image")
	private String cover_image;

	public Book(Long id, String title, String author, String genre, String publication_date, String isbn,
			int quantity_avaliable, String description, String cover_image) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publication_date = publication_date;
		this.isbn = isbn;
		this.quantity_avaliable = quantity_avaliable;
		this.description = description;
		this.cover_image = cover_image;
	}

	public Book(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQuantity_avaliable() {
		return quantity_avaliable;
	}

	public void setQuantity_avaliable(int quantity_avaliable) {
		this.quantity_avaliable = quantity_avaliable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}
}
