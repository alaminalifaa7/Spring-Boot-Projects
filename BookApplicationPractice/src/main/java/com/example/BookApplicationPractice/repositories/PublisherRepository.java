package com.example.BookApplicationPractice.repositories;

import com.example.BookApplicationPractice.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
