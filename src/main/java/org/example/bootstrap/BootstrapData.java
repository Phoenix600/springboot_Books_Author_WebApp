package org.example.bootstrap;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
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
    public void run(String...args)
    {
        // Data Series -01
        Author eric = new Author();
        eric.setFirstName("Pranat");
        eric.setLastName("Ramteke");
        Author ericSaved = authorRepository.save(eric);

        Book ddd = new Book();
        ddd.setTitle("Data Driven Design");
        ddd.setIsbn("123456");
        Book dddSaved = bookRepository.save(ddd);

        // Data Series - 02
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        Author rodSaved = authorRepository.save(rod);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE development without EJB");
        noEJB.setIsbn("789065");
        Book noEJBSaved = bookRepository.save(noEJB);

        // Building th association
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        System.out.println("In BootStrap :");
        System.out.println("Author Count : " + authorRepository.count());
        System.out.println("Books Count : " + bookRepository.count());

    }
}
