package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.entity.Book;
import com.enigma.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiURLConstant.BOOK)
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public List<Book> getBookById() {
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
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
