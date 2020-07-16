package com.cg.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="category")
public class Category {
	@Id   
	@Column(length=12)   
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long CategoryId;
	@Column(length=50)
	public String CategoryName;
	
	@JsonBackReference
	@OneToMany(mappedBy="category")
	private List<Book> books = new ArrayList<Book>();

	public long getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public Category() {}
	public Category(int categoryId, String categoryName, List<Book> books) {
		
		CategoryId = categoryId;
		CategoryName = categoryName;
		this.books = books;
	}
	
	
}
