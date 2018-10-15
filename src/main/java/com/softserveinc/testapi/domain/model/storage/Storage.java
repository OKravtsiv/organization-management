package com.softserveinc.testapi.domain.model.storage;

import com.softserveinc.testapi.domain.model.entity.Identifiable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public abstract class Storage<T extends Identifiable> {
    private Map<Long, T> container;

    public Storage() {
        this.container = new HashMap<>();
    }

    public List<T> getAll() {
        return new ArrayList<>(container.values());
    }

    public T getById(Long id) {
        return container.get(id);
    }

    public void removeById(Long id) {
        container.remove(id);
    }

    public T save(T object) {
        if(container.containsKey(object.getId())) {
            return container.compute(object.getId(), (key, value) -> value = object);
        }
        return container.put(object.getId(), object);
    }

    public void saveAll(List<T> objects) {
        objects.forEach(this::save);
    }
}
