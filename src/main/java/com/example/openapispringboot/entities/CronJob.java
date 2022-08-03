package com.example.openapispringboot.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Getter
@Setter
public class CronJob {

    @Id
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String value;

}
