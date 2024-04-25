package com.example.demo.BookServ;

import java.util.List;


import com.example.demo.model.Category;

public interface CatgoryServ {
	public String SaveAll(Category category);
	public List<Category> findALLData();


}
