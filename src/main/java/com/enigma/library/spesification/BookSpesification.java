package com.enigma.library.spesification;

import com.enigma.library.dto.BookSearchDTO;
import com.enigma.library.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BookSpesification {
    public static Specification<Book> getSpesification(BookSearchDTO bookSearchDTO) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (bookSearchDTO.getSearchBookTitle() != null) {
                    Predicate searchBookTitle = criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + bookSearchDTO.getSearchBookTitle().toLowerCase(Locale.ROOT) + "%");
                    predicates.add(searchBookTitle);
                }
                if (bookSearchDTO.getSearchBookCategory() != null) {
                    Predicate searchBookCategory = criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), "%" + bookSearchDTO.getSearchBookCategory().toLowerCase(Locale.ROOT) + "%");
                    predicates.add(searchBookCategory);
                }
                if (bookSearchDTO.getSearchBookPublisher() != null) {
                    Predicate searchBookPublisher = criteriaBuilder.like(criteriaBuilder.lower(root.get("publisher")), "%" + bookSearchDTO.getSearchBookPublisher().toLowerCase(Locale.ROOT) + "%");
                    predicates.add(searchBookPublisher);
                }
                if (bookSearchDTO.getSearchBookAuthor() != null) {
                    Predicate searchBookAuthor = criteriaBuilder.like(criteriaBuilder.lower(root.get("author")), "%" + bookSearchDTO.getSearchBookAuthor().toLowerCase(Locale.ROOT) + "%");
                    predicates.add(searchBookAuthor);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}