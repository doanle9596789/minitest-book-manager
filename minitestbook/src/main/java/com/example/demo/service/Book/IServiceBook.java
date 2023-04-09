package com.example.demo.service.Book;

import com.example.demo.model.Book;
import com.example.demo.service.IGeneralBook;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IServiceBook extends IGeneralBook<Book> {
    Double totalPrice();
}
