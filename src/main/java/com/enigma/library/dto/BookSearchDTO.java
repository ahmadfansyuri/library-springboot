package com.enigma.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class BookSearchDTO {
    private String searchBookTitle;
    private String searchBookCategory;
    private String searchBookAuthor;
    private String searchBookPublisher;
}
