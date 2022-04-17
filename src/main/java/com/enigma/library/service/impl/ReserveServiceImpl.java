package com.enigma.library.service.impl;

import com.enigma.library.entity.Book;
import com.enigma.library.entity.BookDetails;
import com.enigma.library.entity.Member;
import com.enigma.library.entity.Reserve;
import com.enigma.library.repository.BookDetailsRepository;
import com.enigma.library.repository.BookRepository;
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
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Reserve> getAllReserve() {
        return reserveRepository.findAll();
    }

    @Override
    public void saveReserve(Date dateReserve, Date dateReturn, String memberId, Integer bookDetailsId) {
        Member member = memberRepository.findById(memberId).get();
        BookDetails bookDetails = bookDetailsRepository.findById(bookDetailsId).get();

        int getBookQty = bookDetails.getBook().getQuantity();
        Reserve reserve = new Reserve();
        reserve.setQty(0);

        if (getBookQty >= 0 & reserve.getQty() <= 3) {
            bookDetails.getBook().setQuantity(getBookQty-1);
            reserve.setBookDetails(bookDetails);
            reserve.setMember(member);
            reserve.setDateReserve(dateReserve);
            reserve.setDateReturn(dateReturn);
            reserve.setStatus("Active");
            reserve.setQty(reserve.getQty()+1);
            reserveRepository.save(reserve);
        }
    }

    @Override
    public void returnBook(Integer id) {
        Reserve reserve = reserveRepository.findById(id).get();

        Book book = bookRepository.findById(reserve.getBookDetails().getBook().getId()).get();

        book.setQuantity(book.getQuantity() + reserve.getQty());
        bookRepository.save(book);
        reserve.setStatus("Inactive");
        reserve.setQty(0);
        reserveRepository.save(reserve);
    }
}
