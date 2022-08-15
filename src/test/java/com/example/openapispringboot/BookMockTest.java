package com.example.openapispringboot;

import com.example.openapispringboot.controllers.BookController;
import com.example.openapispringboot.entities.Book;
import com.example.openapispringboot.repositories.BookRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BookMockTest {

    private MockMvc mockMvc;

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookController bookController;


    @BeforeEach
    public void setUp() {
        System.out.println("init");
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void createBook() throws Exception {

        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setAuthor("Thang");
        book.setTitle("book 1");
        book.setId(new ObjectId().toHexString());

        books.add(book);

        book.setAuthor("Thang Pham");
        book.setTitle("book 2");
        book.setId(new ObjectId().toHexString());

        books.add(book);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/books"))
//                .andExpect(status().isOk());

        Assertions.assertEquals(bookRepository.findAll().size(), 2);

    }

    @Test
    @Order(2)
    void findById() {
    }

    @Test
    @Order(3)
    void findBooks() {
    }

    @Test
    @Order(4)
    void updateBook() {
    }
}