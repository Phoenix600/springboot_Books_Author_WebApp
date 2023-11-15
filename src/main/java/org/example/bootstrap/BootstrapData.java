package org.example.bootstrap;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        // Data Series -03
        Publisher publisher = new Publisher();
        publisher.setPublisherName("No Scratch Press");
        publisher.setCity("London");
        publisher.setState("London");
        publisher.setAddress("Wt. Street A");
        publisher.setZipCode("12340");

        Publisher publisherSaved =  publisherRepository.save(publisher);
        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);

        // Building th association
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);



        System.out.println("In BootStrap :");
        System.out.println("Author Count : " + authorRepository.count());
        System.out.println("Books Count : " + bookRepository.count());
        System.out.println("Publisher Count : " + publisherRepository.count());
    }
}
