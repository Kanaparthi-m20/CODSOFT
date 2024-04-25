package com.example.demo.Bookcontroller;

import com.example.demo.model.Category;

public class OrderRequest {
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public OrderRequest(Category category) {
		super();
		this.category = category;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
