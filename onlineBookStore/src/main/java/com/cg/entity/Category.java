package com.cg.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="category")
public class Category {
	@Id   
	@Column(length=12)   
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long CategoryId;
	@Column(length=50)
	public String CategoryName;
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name="CategoryId")
	@ManyToOne(optional = false)
    @JoinColumn(name="book_id")
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
	
}
