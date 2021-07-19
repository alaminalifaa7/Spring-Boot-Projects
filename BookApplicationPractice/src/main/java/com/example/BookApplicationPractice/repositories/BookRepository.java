package com.example.BookApplicationPractice.repositories;

import com.example.BookApplicationPractice.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
