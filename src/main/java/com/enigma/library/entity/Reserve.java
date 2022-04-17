package com.enigma.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter@Setter@NoArgsConstructor
@Entity
@Table(name = "trx_reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_reserve_generator")
    @SequenceGenerator(name = "trx_reserve_generator", sequenceName = "trx_reserve_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "date_reserve")
    private Date dateReserve;
    @Column(name = "date_return")
    private Date dateReturn;
    private Integer qty;
    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_details_id")
    private BookDetails bookDetails;

}
