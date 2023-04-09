package com.example.demo.service.Book;

import com.example.demo.model.Book;
import com.example.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements IServiceBook{
    @Autowired
    private IRepository repository;
    @Override
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public void remove(Long id) {
repository.deleteById(id);
    }

    @Override
    public Double totalPrice() {
        List<Book>list=repository.findAll();
        double total= (double) 0;
        for (Book book:list) {
            total+= book.getPrice();
        }
        return total;
    }
}
