package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
	@OneToMany(targetEntity=Book.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cp_fk",referencedColumnName="id")
	private List<Book> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Category(Long id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
 
}