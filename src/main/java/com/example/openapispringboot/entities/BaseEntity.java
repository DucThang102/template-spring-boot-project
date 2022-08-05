package com.example.openapispringboot.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract class BaseEntity {
    @Id
    private ObjectId id;

    public String getId() {
        return id.toHexString();
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
    }

}
