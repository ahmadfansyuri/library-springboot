package com.enigma.library.repository;

import com.enigma.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    @Query(value = "SELECT * FROM mst_book", nativeQuery = true)
    public List<Book> getAllNative();

    @Query(value = "SELECT * FROM mst_book u WHERE u.id= ?1", nativeQuery = true)
    public Book getByIdNative(String id);

    @Query(value = "DELETE FROM mst_book u WHERE u.id= ?1", nativeQuery = true)
    public Book deleteByIdNative(String id);
}
