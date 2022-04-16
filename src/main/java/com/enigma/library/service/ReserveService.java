package com.enigma.library.service;

import com.enigma.library.entity.Member;
import com.enigma.library.entity.Reserve;

import java.util.List;

public interface ReserveService {
    public List<Reserve> getAllReserve();

    public Reserve saveMember(Reserve reserve);
}
