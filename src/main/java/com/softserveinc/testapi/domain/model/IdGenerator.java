package com.softserveinc.testapi.domain.model;

public class IdGenerator {
    private static long id = 0;

    public static long generateId() {
        return id += 1;
    }
}
