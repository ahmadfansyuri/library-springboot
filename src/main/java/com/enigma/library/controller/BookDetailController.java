package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.entity.Book;
import com.enigma.library.entity.BookDetails;
import com.enigma.library.entity.Reserve;
import com.enigma.library.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiURLConstant.BOOKDETAIL)
public class BookDetailController {
    @Autowired
    BookDetailsService bookDetailsService;

    @GetMapping
    public List<BookDetails> getAllBookDetails() {
        return bookDetailsService.getAllDetails();
    }

    @PostMapping
    public void saveMember(@RequestParam String id) { bookDetailsService.saveMember(id); }
}
