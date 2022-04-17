package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.dto.BookSearchDTO;
import com.enigma.library.entity.Book;
import com.enigma.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping
    public Page<Book> getBookPerPage(@RequestBody BookSearchDTO bookSearchDTO,
                                     @RequestParam(name="page", defaultValue = "0") Integer page,
                                     @RequestParam(name="size", defaultValue = "3") Integer size,
                                     @RequestParam(name="sortby", defaultValue = "title") String sort,
                                     @RequestParam(name="direction", defaultValue = "asc") String dir) {
        Sort sorting = Sort.by(Sort.Direction.fromString(dir), sort);
        Pageable pageable = PageRequest.of(page, size, sorting);
        return bookService.getBookPerPage(pageable, bookSearchDTO);
    }
}
