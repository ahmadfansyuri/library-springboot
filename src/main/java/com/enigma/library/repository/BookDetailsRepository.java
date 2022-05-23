package com.enigma.library.repository;

import com.enigma.library.entity.Book;
import com.enigma.library.entity.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetails, Integer> {
    @Query(value = "SELECT * FROM trx_book_details", nativeQuery = true)
    public List<BookDetails> getAllNative();

}
