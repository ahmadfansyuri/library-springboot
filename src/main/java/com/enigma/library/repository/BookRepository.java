package com.enigma.library.repository;

import com.enigma.library.dto.BookSearchDTO;
import com.enigma.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String>, JpaSpecificationExecutor {
    Page<Book> findAll (Specification bookSpecification, Pageable pageable);
}
