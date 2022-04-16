package com.enigma.library.controller;

import com.enigma.library.constant.ApiURLConstant;
import com.enigma.library.entity.Reserve;
import com.enigma.library.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiURLConstant.RESERVE)
public class ReserveController {
    @Autowired
    ReserveService reserveService;

    @GetMapping
    public List<Reserve> getAllReserve() {
        return reserveService.getAllReserve();
    }

    @PostMapping
    public Reserve saveMember(@RequestBody Reserve reserve) { return reserveService.saveMember(reserve); }
}
