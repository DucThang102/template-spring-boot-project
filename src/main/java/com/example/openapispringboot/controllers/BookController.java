package com.example.openapispringboot.controllers;

import com.example.openapispringboot.entities.Book;
import com.example.openapispringboot.exceptions.NotFoundException;
import com.example.openapispringboot.repositories.BookRepository;
import com.example.openapispringboot.services.dtos.BaseResponse;
import com.example.openapispringboot.services.dtos.ResponseData;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/")
    public ResponseData<Book> createBook(@RequestBody Book book) {
        ResponseData<Book> responseData = new ResponseData<>();
        Book savedBook = repository.save(book);
        responseData.setSuccess(savedBook);
        return responseData;
    }

    @GetMapping("/{id}")
    public ResponseData<Book> findById(@PathVariable String id) {
        ResponseData<Book> responseData = new ResponseData<>();
        Optional<Book> book = repository.findById(new ObjectId(id));

        if (book.isPresent()) {
            responseData.setSuccess(book.get());
        } else {
            throw new NotFoundException();
        }
        return responseData;
    }

    @GetMapping("/")
    public ResponseData<List<Book>> findBooks() {
        ResponseData<List<Book>> responseData = new ResponseData<>();
        List<Book> bookList =  repository.findAll();

        responseData.setSuccess(bookList);
        return responseData;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<Book> updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        ResponseData<Book> responseData = new ResponseData<>();
        if (repository.existsById(new ObjectId(id))) {
            book = repository.save(book);
            responseData.setSuccess(book);
        } else {
            throw new NotFoundException();
        }
        return responseData;
    }



}