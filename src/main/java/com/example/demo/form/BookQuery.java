package com.example.demo.form;

import lombok.Data;

@Data
public class BookQuery {
	private String name;
	
	public BookQuery() {
		name="";
	}
}
