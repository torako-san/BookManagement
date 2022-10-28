package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.model.Book;
import com.example.demo.domain.repository.BookRepository;

@Service
@Transactional
public class BookService {
	@Autowired
	BookRepository repository;

	public void save(Book book) {
		String userId = "loglog";
		Date now = new Date();
		book.setCreated_user(userId);
		book.setCreated_at(now);
		book.setUpdated_user(userId);
		book.setUpdated_at(now);
		repository.save(book);
	}
	
	public ArrayList<Book> selectMany(Map<String, String>params) {
		return repository.selectMany(params);
	}

	public boolean existsIsbn(String isbn) {
		return repository.existsIsbn(isbn) == null ? false : true;
	}

}