package com.enigma.library.service.impl;

import com.enigma.library.dto.MemberSearchDTO;
import com.enigma.library.entity.Book;
import com.enigma.library.entity.Member;
import com.enigma.library.repository.MemberRepository;
import com.enigma.library.service.MemberService;
import com.enigma.library.spesification.BookSpesification;
import com.enigma.library.spesification.MemberSpesification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Page<Member> getMemberPerPage(Pageable pageable, MemberSearchDTO memberSearchDTO) {
        Specification<Member> memberSpecification = MemberSpesification.getSpesification(memberSearchDTO);
        return memberRepository.findAll(memberSpecification, pageable);
    }


}

