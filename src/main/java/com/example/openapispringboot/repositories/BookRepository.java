package com.example.openapispringboot.repositories;

import com.example.openapispringboot.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {
}
