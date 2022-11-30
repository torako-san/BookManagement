package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.BookRepository;
import com.example.demo.model.Book;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final BookRepository repository;
	
	@GetMapping("/")
	public String index() {
		 return "index";
	}
	
	@GetMapping("book/add")
	public String add(@ModelAttribute Book book) {
		return "book/add";
	}
	
	@PostMapping("book/list")
	public String list(@Validated @ModelAttribute Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "book/add";
		}
		repository.save(book);
		return "redirect:/";
	}

	@GetMapping("book/list")
	public String showList (Model model){
		model.addAttribute("books", repository.findAll());
		return "book/list";
	}
	
	@GetMapping("book/edit/{id}")
	public String editBook(@PathVariable Long id,  Model model) {
		model.addAttribute("book", repository.findById(id));
		return "book/edit";
	}
	
	@PostMapping("book/update")
	public String updateBook(@Validated @ModelAttribute Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "book/edit";
		}
		repository.save(book);
		model.addAttribute("books", repository.findAll());
		return "book/list";
	}
	
	@GetMapping("book/delete/{id}")
	public String deleteBook(@PathVariable Long id, Model model) {
		repository.deleteById(id);
		model.addAttribute("books", repository.findAll());
		return "book/list";
	}
}
