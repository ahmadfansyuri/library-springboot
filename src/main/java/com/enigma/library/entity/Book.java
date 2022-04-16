package com.enigma.library.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter@Setter@NoArgsConstructor
@Entity
@Table(name = "mst_book")
public class Book {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "book_id")
    private String id;
    private String title;
    private String category;
    private String author;
    private String publisher;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer quantity;
}
