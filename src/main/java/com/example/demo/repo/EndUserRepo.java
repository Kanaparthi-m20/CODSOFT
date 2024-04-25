package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EndUser;

public interface EndUserRepo extends JpaRepository<EndUser,Long> {
    EndUser findByEmail(String email);
}