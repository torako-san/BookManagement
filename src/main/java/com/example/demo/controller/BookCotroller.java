package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.controller.form.BookForm;

@Controller
public class BookCotroller {
		
	@GetMapping("book/add")
	public String getAdd(BookForm form, Model model) {
		model.addAttribute("bookForm", form);
		return "book/add";
	}
}
