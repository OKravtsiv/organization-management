package com.softserveinc.testapi.domain.model.entity;

import static com.softserveinc.testapi.domain.model.IdGenerator.*;

public abstract class Identifiable {
    protected final long id;

    public Identifiable() {
        this.id = generateId();
    }

    public long getId() {
        return id;
    }
}
