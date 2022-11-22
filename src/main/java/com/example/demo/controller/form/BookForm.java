package com.example.demo.controller.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {
	
	private int id; //登録データのID
	
	@Size(min=1, max=100)
	private String name; //書籍名
	
	@Pattern(regexp= "^[0-9]{13}$")
	private String isbn; //ISBNコード
	
	@Size(max=500)
	private String description; //書籍の内容
	
	@Size(max=100)
	private String publisher; //出版社
	
	@NotNull
	@Min(0)
	private Integer price; //本の価格
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publication_date; //本の購入日
	
	private int version; //データの更新日

}
