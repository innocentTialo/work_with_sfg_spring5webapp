package com.africafuture.spring5webapp.bootstrap;

import com.africafuture.spring5webapp.domain.Author;
import com.africafuture.spring5webapp.domain.Book;
import com.africafuture.spring5webapp.repository.AuthorRepository;
import com.africafuture.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "15214478");
        eric.addBook(ddd);
        ddd.addAuthor(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "362584521");
        rod.addBook(ddd);
        noEJB.addAuthor(eric);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("started in Bootstrap");
        System.out.println("Number of books created: "+ bookRepository.count());

    }
}
