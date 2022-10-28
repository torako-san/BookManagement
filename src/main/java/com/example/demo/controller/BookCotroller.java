package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.form.BookForm;
import com.example.demo.domain.model.Book;
import com.example.demo.service.BookService;

@Controller
public class BookCotroller {
	
	@Autowired
	BookService service;
		
	@GetMapping("book/add")
	public String getAdd(BookForm form, Model model) {
		model.addAttribute("bookForm", form);
		return "book/add";
	}
	
	@PostMapping("book/create")
	public String postCreate(@Validated BookForm form, BindingResult result, Model model) {
	
//		if(service.existsIsbn(form.getIsbn())) {
//			// ISBNコードが既に使われていれば、エラーとなるフィールド(isbn)とエラーコード(existsIsbn)を設定
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
	
	@GetMapping("book/list")
	public String getList(Model model) {
		return "book/list";
	}
	
	@GetMapping("book/seach")
	public String getSearch(@RequestParam Map<String, String> params, Model model) {
		
		// 取得したリクエストパラメータを引数として、サービス層に検索処理を委譲
		ArrayList<Book> books = service.selectMany(params);
		
		// 検索結果のオブジェクトをmodelに格納
		model.addAttribute("books", books);
		
		// 取得結果をReturn
		return "book/list";
	}
		
}
