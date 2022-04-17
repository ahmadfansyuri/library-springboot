package com.enigma.library.service.impl;

import com.enigma.library.dto.BookSearchDTO;
import com.enigma.library.entity.Book;
import com.enigma.library.repository.BookRepository;
import com.enigma.library.service.BookService;
import com.enigma.library.spesification.BookSpesification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> getBookPerPage(Pageable pageable, BookSearchDTO bookSearchDTO) {
        Specification<Book> bookSpecification = BookSpesification.getSpesification(bookSearchDTO);
        return bookRepository.findAll(bookSpecification, pageable);
    }
}
