package com.enigma.library.service;

import com.enigma.library.entity.Member;
import com.enigma.library.entity.Reserve;

import java.sql.Date;
import java.util.List;

public interface ReserveService {
    public List<Reserve> getAllReserve();

    void saveReserve(Date dateReserve, Date dateReturn, String memberId, Integer bookDetailsId);
}
