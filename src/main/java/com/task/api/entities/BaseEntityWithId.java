package com.task.api.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
//@Access(AccessType.PROPERTY)
public class BaseEntityWithId extends BaseEntity {

    @Id
    @GeneratedValue
    public long id;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "<" + id + ">";
    }
}
