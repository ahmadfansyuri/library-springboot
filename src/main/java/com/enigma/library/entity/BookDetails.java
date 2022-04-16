package com.enigma.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter@NoArgsConstructor
@Entity
@Table(name = "trx_book_details")
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_reserve_generator")
    @SequenceGenerator(name = "trx_reserve_generator", sequenceName = "trx_reserve_seq", allocationSize = 1)
    @Column(name = "book_details_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
