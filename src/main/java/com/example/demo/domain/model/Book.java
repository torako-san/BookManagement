package com.example.demo.domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.controller.form.BookForm;

import lombok.Data;

@Data
public class Book {
	// MybatisのresultMap用にデフォルトコンストラクタ
	public Book() {}	
	
	// BookFormの値を格納するためのコンストラクタ
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
	
	// ISBNコードをハイフンで区切って表示
	public String isbnFormat() {
		String prefix = isbn.substring(0,3);			// 接頭記号(3桁)
		String group = isbn.substring(3,4);				// グループ記号(1桁)
		String publisher = isbn.substring(4,10);		// 出版者記号(6桁)
		String bookName = isbn.substring(10,12);		// 書名記号(2桁)
		String checkDigit = isbn.substring(12,13);		// チェックディジット(1桁)
		return String.join("-", prefix, group, publisher, bookName, checkDigit);
	}

	// ゼロを3つごとにカンマで区切る
	public String priceCommaOf1000() {
		return String.format("%,d", price);
	}

	// 日付を和暦(年月日)表示にする
	public String publicationDateOfYyyymmdd() {
		if(publication_date == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(publication_date).toString();
	}
}