package com.example.demo.Bookcontroller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BookRepo.BookRepo;
import com.example.demo.BookServ.CatImpl;
import com.example.demo.model.Category;


@RestController
@RequestMapping("/book")
public class CategoryController {
	
	@Autowired
	private BookRepo prodRepo;
	@Autowired	
	private CatImpl cust;
	
	@PostMapping("/save")
	public ResponseEntity<String> placeAll(@RequestBody OrderRequest request){
//		System.out.println(request.getCategory());
		String status=cust.SaveAll(request.getCategory());
		return new ResponseEntity<>("saved successfully",HttpStatus.CREATED);
		
	}
	@GetMapping("/get")
	public ResponseEntity<List<Category>> getAll(){
		List<Category> cut=cust.findALLData();
		return new ResponseEntity<>(cut,HttpStatus.OK);
	}
}