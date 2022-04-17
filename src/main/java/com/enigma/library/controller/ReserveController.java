package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.entity.Reserve;
import com.enigma.library.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(ApiURLConstant.RESERVE)
public class ReserveController {

    final
    ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @GetMapping
    public List<Reserve> getAllReserve() {
        return reserveService.getAllReserve();
    }

    @PostMapping
    public void saveMember(@RequestParam Date dateReserve, @RequestParam Date dateReturn, @RequestParam String memberId, @RequestParam Integer bookDetailsId) {
        reserveService.saveReserve(dateReserve, dateReturn, memberId, bookDetailsId);
    }

    @PutMapping
    public void returnBook(@RequestParam Integer id) {
        reserveService.returnBook(id);
    }
}
