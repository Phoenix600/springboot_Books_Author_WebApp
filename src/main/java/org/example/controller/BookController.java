package org.example.controller;

import org.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public  BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books",bookService.findAll());
        return "books";
    }

}
