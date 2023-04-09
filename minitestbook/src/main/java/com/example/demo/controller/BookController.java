package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.IRepository;
import com.example.demo.service.Book.IServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private IServiceBook serviceBook;
    private IRepository repository;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Book>> listBook(){
        return new ResponseEntity<>(serviceBook.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Book>createBook(@RequestBody Book book){
        return new ResponseEntity<>(serviceBook.save(book),HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book>editBook(@PathVariable(value = "id") Long id,@RequestBody Book book){
        Optional<Book>optionalBook=serviceBook.findById(id);
        if (!optionalBook.isPresent()){
            return ResponseEntity.notFound().build();
        }else {
            book.setId(optionalBook.get().getId());
         return new ResponseEntity<>(serviceBook.save(book),HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book>deleteBook(@PathVariable(value = "id") Long id){
        Optional<Book>optionalBook=serviceBook.findById(id);
        if (optionalBook.isPresent()){
            serviceBook.remove(id);
            return ResponseEntity.noContent().build();

        }else {return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/total-price")
    public Double getTotalPrice() {
        return serviceBook.totalPrice();
    }
    @GetMapping("/search")
    public List<Book>list(@RequestParam(value = "name") String name,
                          @RequestParam(value = "author") String author,
                          @RequestParam(value = "minPrice") Double minPrice,
                          @RequestParam(value = "maxPrice") Double maxPrice){
        List<Book> books = new ArrayList<Book>();
        if (name!=null){
          books.addAll(repository.findByNameContainingIgnoreCase(name)) ;
        }if (author!=null){
           books.addAll(repository.findByAuthorContainingIgnoreCase(author)) ;
        }  if (minPrice != null && maxPrice != null) {
            books.addAll(repository.findByPriceBetween(minPrice, maxPrice));
        }
        return books;
    }

}
