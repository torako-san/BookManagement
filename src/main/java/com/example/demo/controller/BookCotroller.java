package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.form.BookForm;
import com.example.demo.domain.model.Book;
import com.example.demo.service.BookService;

@Controller
public class BookCotroller {
		
	@GetMapping("book/add")
	public String getAdd(BookForm form, Model model) {
		model.addAttribute("bookForm", form);
		return "book/add";
	}
	
	@PostMapping("book/create")
	public String postCreate(@Validated BookForm form, BindingResult result, Model model, BookService service) {
		// ISBNコードは登録されているデータ内で一意である必要があるため、
		// 既に登録済みであることをチェックしています。
		
//		if(service.existsIsbn(form.getIsbn())) {
//			// ISBNコードが既に使われていれば、
//			// エラーとなるフィールド(isbn)とエラーコード(existsIsbn)を設定します。
//			result.rejectValue("isbn", "existsIsbn");
//		}

		// エラーがあれば登録フォームを再表示させます。
		if(result.hasErrors()) {
			return getAdd(form, model);
		}

		// formで受け取った値をエンティティであるBookに格納します。
		Book book = new Book(form);

		// 登録処理をServiceに委譲します。
		service.save(book);

		// 検索一覧画面に遷移します。
		return "book/list";
	}
}
