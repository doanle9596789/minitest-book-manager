package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRepository extends JpaRepository<Book,Long> {
    List<Book>findByNameContainingIgnoreCase(String name);
    List<Book>findByAuthorContainingIgnoreCase( String author);
    List<Book>findByPriceBetween(double minPrice,double maxPrice);
}
