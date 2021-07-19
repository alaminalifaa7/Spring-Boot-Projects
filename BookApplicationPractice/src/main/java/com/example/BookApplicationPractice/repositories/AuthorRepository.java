package com.example.BookApplicationPractice.repositories;

import com.example.BookApplicationPractice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}

