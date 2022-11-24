package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Book {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=1, max=100)
	private String name;
	
	@Pattern(regexp= "^[0-9]{13}$")
	private String isbn;
	
	@Size(max=500)
	private String description;
	
	@Size(max=100)
	private String publisher;
	
	@NotNull
	@Min(0)
	private int price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publication_date;
	
	private int version;

}
