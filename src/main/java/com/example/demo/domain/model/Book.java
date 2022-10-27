package com.example.demo.domain.model;

import java.util.Date;

import com.example.demo.controller.form.BookForm;

import lombok.Data;

@Data
public class Book {
	// MybatisのresultMap用にデフォルトコンストラクタを用意しておきます。
	public Book() {}	
	
	// BookFormの値を格納するためのコンストラクタ
	// （Controller内でSetterを使って格納するよりこちらの方がスマート）
	public Book(BookForm form) {
		this.id = form.getId();
		this.name = form.getName();
		this.isbn = form.getIsbn();
		this.description = form.getDescription();
		this.publisher = form.getPublisher();
		this.price = form.getPrice();
		this.publication_date = form.getPublication_date();
		this.version = form.getVersion();
	}

	private int id;
	private String name;
	private String isbn;
	private String description;
	private String publisher;
	private int price;
	private Date publication_date;
	private String created_user;
	private Date created_at;
	private String updated_user;
	private Date updated_at;
	private String deleted_user;
	private Date deleted_at;
	private int version;
}