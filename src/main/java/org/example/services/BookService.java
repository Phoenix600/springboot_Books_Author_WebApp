package org.example.services;

import org.example.entity.Book;
import org.springframework.stereotype.Service;


public interface BookService {
    Iterable<Book> findAll();
}
