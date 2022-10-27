package com.example.demo.controller.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookForm {
	
	private int id;
	
	private String name;
	
	private String isbn;
	
	private String description;
	
	private String publisher;
	
	private Integer price;
	
	private int version;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publication_date;
	
	public BookForm () {}
	
	public BookForm(Book book) {
		this.id = book.getId();
		this.name = book.getName();
		this.isbn = book.getIsbn();
		this.description = book.getDescription();
		this.publisher = book.getPublisher();
		this.publication_date = book.getPublication_date();
		this.price = book.getPrice();
		this.version = book.getVersion();
	}
	
}
