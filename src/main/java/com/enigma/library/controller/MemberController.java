package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.dto.BookSearchDTO;
import com.enigma.library.dto.MemberSearchDTO;
import com.enigma.library.entity.Book;
import com.enigma.library.entity.Member;
import com.enigma.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ApiURLConstant.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;
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

    @GetMapping
    public Page<Member> getMemberPerPage(@RequestBody MemberSearchDTO memberSearchDTO,
                                        @RequestParam(name="page", defaultValue = "0") Integer page,
                                        @RequestParam(name="size", defaultValue = "3") Integer size,
                                        @RequestParam(name="sortby", defaultValue = "firstName") String sort,
                                        @RequestParam(name="direction", defaultValue = "asc") String dir) {
        Sort sorting = Sort.by(Sort.Direction.fromString(dir), sort);
        Pageable pageable = PageRequest.of(page, size, sorting);
        return memberService.getMemberPerPage(pageable, memberSearchDTO);
    }
}
