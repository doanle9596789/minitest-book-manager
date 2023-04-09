package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
public interface IGeneralBook<T> {
    Iterable<T>findAll();
    Optional<T>findById(Long id);
    T save(T t);
    void remove(Long id);
}
