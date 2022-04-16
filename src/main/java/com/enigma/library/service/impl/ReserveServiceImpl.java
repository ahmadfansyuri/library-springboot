package com.enigma.library.service.impl;

import com.enigma.library.entity.Reserve;
import com.enigma.library.repository.ReserveRepository;
import com.enigma.library.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    ReserveRepository reserveRepository;

    @Override
    public List<Reserve> getAllReserve() {
        return reserveRepository.findAll();
    }

    @Override
    public Reserve saveMember(Reserve reserve) {
        return reserveRepository.save(reserve);
    }
}
