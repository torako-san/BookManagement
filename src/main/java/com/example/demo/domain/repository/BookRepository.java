package com.example.demo.domain.repository;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.Book;

@Mapper
public interface BookRepository {
	public int save(Book book);

//	public Book existsIsbn(String isbn);
	
	public ArrayList<Book> selectMany(Map<String, String>params);
}