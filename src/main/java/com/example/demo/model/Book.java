package com.example.demo.model;

import java.text.SimpleDateFormat;
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
	private Long id;
	
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

	public String priceCommaOf1000() {
		return String.format("%,d", price);
	}
	
	public String publicationDateOfYyyymmdd() {
		if(publication_date == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(publication_date).toString();
	}
	
	public String isbnFormat() {
		String prefix = isbn.substring(0,3);			// 接頭記号(3桁)
		String group = isbn.substring(3,4);				// グループ記号(1桁)
		String publisher = isbn.substring(4,10);		// 出版者記号(6桁)
		String bookName = isbn.substring(10,12);		// 書名記号(2桁)
		String checkDigit = isbn.substring(12,13);		// チェックディジット(1桁)
		return String.join("-", prefix, group, publisher, bookName, checkDigit);
	}

}
