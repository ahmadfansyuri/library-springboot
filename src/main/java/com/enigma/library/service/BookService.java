package com.enigma.library.service;

import com.enigma.library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBook();
    public Optional<Book> getBookById(String id);
    public Book saveBook(Book book);
    public void deleteBook(String id);
}
