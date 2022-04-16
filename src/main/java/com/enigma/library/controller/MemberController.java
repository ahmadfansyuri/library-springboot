package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.entity.Member;
import com.enigma.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ApiURLConstant.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;
    //
//    public List<Member> getAllMember() {
//        return memberService.getAllMember();
//    }
//
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member saveMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam String id) {
        memberService.deleteMember(id);
    }
}
