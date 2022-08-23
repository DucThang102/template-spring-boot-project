package com.example.openapispringboot.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public abstract class BaseEntity {
    @Id
    private ObjectId id;

    private Date createdOn;

    private Date updatedOn;

    public String getId() {
        return id.toHexString();
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
