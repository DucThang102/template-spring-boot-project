package com.example.openapispringboot;

import com.example.openapispringboot.services.dtos.ResponseData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String host;

    @BeforeEach
    public void init() {
        host = "http://localhost:" + port;
    }

    @Test
    public void testGetBooks() {
        ResponseEntity<ResponseData> response = restTemplate.getForEntity(host+ "/api/books", ResponseData.class);
        System.out.println(response);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().getStatusCode(), 1);
        Assertions.assertEquals(response.getBody().getMessage(), "SUCCESSFUL");

    }
}
