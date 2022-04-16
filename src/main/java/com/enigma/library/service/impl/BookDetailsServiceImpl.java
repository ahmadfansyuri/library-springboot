package com.enigma.library.service.impl;

import com.enigma.library.entity.Book;
import com.enigma.library.entity.BookDetails;
import com.enigma.library.repository.BookDetailsRepository;
import com.enigma.library.repository.BookRepository;
import com.enigma.library.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {
    @Autowired
    BookDetailsRepository bookDetailsRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookDetails> getAllDetails() {
        return bookDetailsRepository.findAll();
    }

    @Override
    public void saveMember(String id) {
        Book book = bookRepository.findById(id).get();
        BookDetails bookDetails = new BookDetails();
        bookDetails.setBook(book);
        bookDetailsRepository.save(bookDetails);
    }

}
