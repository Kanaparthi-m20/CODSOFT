package com.example.demo.BookServ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BookRepo.CategoryRepo;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
@Service
public class CatImpl implements CatgoryServ{
	
	@Autowired
	private CategoryRepo catRepo;

	@Override
	public String SaveAll(Category category) {
		catRepo.save(category);
		return "Saved";
	}

	@Override
	public List<Category> findALLData() {
	
		return catRepo.findAll();
	}


	
}
