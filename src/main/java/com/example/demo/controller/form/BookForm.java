package com.example.demo.controller.form;

import java.util.Date;
import lombok.Data;

@Data
public class BookForm {
	private int id;
	private String name;
	private String isbn;
	private String description;
	private String publisher;
	private Integer price;
	private Date publication_date;
	private int version;
}
