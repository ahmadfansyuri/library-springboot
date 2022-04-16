package com.enigma.library.service;

import com.enigma.library.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public List<Member> getAllMember();
    public Optional<Member> getMemberById(String id);
    public Member saveMember(Member member);
    public void deleteMember(String id);
}
