package com.enigma.library.service;

import com.enigma.library.entity.Book;
import com.enigma.library.entity.BookDetails;
import com.enigma.library.entity.Member;

import java.util.List;

public interface BookDetailsService {
    public List<BookDetails> getAllDetails();
    public void saveMember(String id);
}
