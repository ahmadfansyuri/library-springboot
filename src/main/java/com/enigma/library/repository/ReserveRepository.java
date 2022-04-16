package com.enigma.library.repository;

import com.enigma.library.entity.Member;
import com.enigma.library.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Integer> {
}
