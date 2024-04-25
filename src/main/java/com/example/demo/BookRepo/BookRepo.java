package com.example.demo.BookRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Book;
import com.example.demo.model.Category;

public interface BookRepo extends JpaRepository<Book, Long> {
}
