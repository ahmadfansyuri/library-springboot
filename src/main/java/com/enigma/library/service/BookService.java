package com.enigma.library.service;

import com.enigma.library.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBook();
    public Book getBookById(String id);
    public Book saveBook(Book book);
    public void deleteBook(String id);
}
