package com.enigma.library.service;

import com.enigma.library.dto.BookSearchDTO;
import com.enigma.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBook();
    public Optional<Book> getBookById(String id);
    public Book saveBook(Book book);
    public void deleteBook(String id);
//    public Page<Book> getBookPerPage(Pageable pageable, BookSearchDTO bookSearchDTO);
    public  Page<Book> getBookPerPage(Pageable pageable, BookSearchDTO bookSearchDTO);
}
