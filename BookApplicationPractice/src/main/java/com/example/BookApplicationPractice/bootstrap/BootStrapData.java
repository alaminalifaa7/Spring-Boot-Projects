package com.example.BookApplicationPractice.bootstrap;

import com.example.BookApplicationPractice.model.Author;
import com.example.BookApplicationPractice.model.Book;
import com.example.BookApplicationPractice.model.Publisher;
import com.example.BookApplicationPractice.repositories.AuthorRepository;
import com.example.BookApplicationPractice.repositories.BookRepository;
import com.example.BookApplicationPractice.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub = new Publisher("onnorokom","Azimpur","Dhaka","BD","1205");
        publisherRepository.save(pub);


        Author eric = new Author("Eric","Abidal");
        Book b1 = new Book("Atomic Habits","121312");
        eric.getBooks().add(b1);
        b1.getAuthors().add(eric);
        b1.setPublisher(pub);
        authorRepository.save(eric);
        bookRepository.save(b1);

        Author james = new Author("James","Clear");
        Book b2 = new Book("Pride of Prejudice","341256");
        b2.setPublisher(pub);
        james.getBooks().add(b2);
        b2.getAuthors().add(james);

        authorRepository.save(james);
        bookRepository.save(b2);


        System.out.println("publisher:  "+ publisherRepository.count());

        System.out.println("book: "+bookRepository.count());
      //  System.out.println(bookRepository.findAll());
    }
}
