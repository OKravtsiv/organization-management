package com.softserveinc.testapi.domain.model.entity;

public abstract class Identifiable {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
