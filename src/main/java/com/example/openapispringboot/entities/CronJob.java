package com.example.openapispringboot.entities;

import com.example.openapispringboot.enumable.CronJobType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Getter
@Setter
public class CronJob extends BaseEntity{

    @NotBlank
    private String name;

    private CronJobType type;

    @NotBlank
    private String value;

}
