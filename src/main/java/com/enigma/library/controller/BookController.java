package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.entity.Book;
import com.enigma.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ApiURLConstant.BOOK)
public class BookController {
    @Autowired
    BookService bookService;

    //    public List<Book> getAllBook() {
//
//    }
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam String id) {
        bookService.deleteBook(id);
    }

}
