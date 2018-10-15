package com.softserveinc.testapi.domain.model.storage.generator;

public class IdGeneratorImpl implements IdGenerator {
    private long id = 0;

    public long generateId() {
        return this.id += 1;
    }
}
