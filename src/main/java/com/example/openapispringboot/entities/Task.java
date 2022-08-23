package com.example.openapispringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.Future;

@Document
@Getter
@Setter
@ToString
public class Task extends BaseEntity {

    @JsonIgnore
    private Future future;
    private boolean status;
}
