package com.example.demo.domain.repository;

import java.awt.print.Book;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookRepository  {
	public int save(Book book);
	
	public Book existsIsbn(String isbn);

}
