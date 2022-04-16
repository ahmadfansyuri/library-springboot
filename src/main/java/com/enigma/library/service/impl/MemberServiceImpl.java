package com.enigma.library.service.impl;

import com.enigma.library.entity.Member;
import com.enigma.library.repository.MemberRepository;
import com.enigma.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
}

