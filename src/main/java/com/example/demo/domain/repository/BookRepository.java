package com.example.demo.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.Book;

@Mapper
public interface BookRepository {
	public int save(Book book);

//	public Book existsIsbn(String isbn);

}