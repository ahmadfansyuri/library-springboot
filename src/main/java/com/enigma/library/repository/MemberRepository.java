package com.enigma.library.repository;

import com.enigma.library.entity.Book;
import com.enigma.library.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    @Query(value = "SELECT * FROM mst_member", nativeQuery = true)
    public List<Member> getAllNative();

    @Query(value = "SELECT * FROM mst_member u WHERE u.id= ?1", nativeQuery = true)
    public Member getByIdNative(String id);

    @Query(value = "DELETE FROM mst_member u WHERE u.id= ?1", nativeQuery = true)
    public Member deleteByIdNative(String id);
}
