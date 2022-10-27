package com.example.demo.controller.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.domain.model.Book;

import lombok.Data;

@Data
public class BookForm {

	private int id;

	@Size(min=1, max=100)
	private String name;

	@Pattern(regexp = "^[0-9]{13}$")
	private String isbn;

	private String description;

	@Size(max=100)
	private String publisher;

	@NotNull
	@Min(0)
	private Integer price;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publication_date;

	private int version;

	public BookForm() {}

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