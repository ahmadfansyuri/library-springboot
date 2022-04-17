package com.enigma.library.service.impl;

import com.enigma.library.entity.Book;
import com.enigma.library.entity.BookDetails;
import com.enigma.library.entity.Member;
import com.enigma.library.entity.Reserve;
import com.enigma.library.repository.BookDetailsRepository;
import com.enigma.library.repository.MemberRepository;
import com.enigma.library.repository.ReserveRepository;
import com.enigma.library.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    ReserveRepository reserveRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BookDetailsRepository bookDetailsRepository;

    @Override
    public List<Reserve> getAllReserve() {
        return reserveRepository.findAll();
    }

    @Override
    public void saveReserve(Date dateReserve, Date dateReturn, String memberId, Integer bookDetailsId) {
        Member member = memberRepository.findById(memberId).get();
        BookDetails bookDetails = bookDetailsRepository.findById(bookDetailsId).get();
        Reserve reserve = new Reserve();

        int getBookQty = bookDetails.getBook().getQuantity();

        if (getBookQty >= 0) {
            bookDetails.getBook().setQuantity(getBookQty-1);
            reserve.setBookDetails(bookDetails);
            reserve.setMember(member);
            reserve.setDateReserve(dateReserve);
            reserve.setDateReturn(dateReturn);

            reserveRepository.save(reserve);
        }
    }

//    Book book = bookRepository.findById(id).get();
//    BookDetails bookDetails = new BookDetails();
//        bookDetails.setBook(book);
//        bookDetailsRepository.save(bookDetails);
}
