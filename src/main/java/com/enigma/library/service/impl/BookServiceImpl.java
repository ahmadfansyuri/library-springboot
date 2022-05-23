package com.enigma.library.service.impl;

import com.enigma.library.entity.Book;
import com.enigma.library.repository.BookRepository;
import com.enigma.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllNative();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.getByIdNative(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

}
