package com.enigma.library.service;

import com.enigma.library.dto.BookSearchDTO;
import com.enigma.library.dto.MemberSearchDTO;
import com.enigma.library.entity.Book;
import com.enigma.library.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public List<Member> getAllMember();
    public Optional<Member> getMemberById(String id);
    public Member saveMember(Member member);
    public void deleteMember(String id);
    public Page<Member> getMemberPerPage(Pageable pageable, MemberSearchDTO memberSearchDTO);
}

