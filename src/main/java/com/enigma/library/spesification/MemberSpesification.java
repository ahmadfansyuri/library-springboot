package com.enigma.library.spesification;

import com.enigma.library.dto.MemberSearchDTO;
import com.enigma.library.entity.Member;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MemberSpesification {
    public static Specification<Member> getSpesification(MemberSearchDTO memberSearchDTO) {
        return new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (memberSearchDTO.getSearchFirstName() != null) {
                    Predicate searchFirstName = criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + memberSearchDTO.getSearchFirstName().toLowerCase(Locale.ROOT) + "%");
                    predicates.add(searchFirstName);
                }
                if (memberSearchDTO.getSearchLastName() != null) {
                    Predicate searchLastName = criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + memberSearchDTO.getSearchLastName().toLowerCase(Locale.ROOT) + "%");
                    predicates.add(searchLastName);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
    }

