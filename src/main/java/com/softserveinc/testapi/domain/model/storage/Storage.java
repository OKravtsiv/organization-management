package com.softserveinc.testapi.domain.model.storage;

import com.softserveinc.testapi.domain.model.entity.Identifiable;
import com.softserveinc.testapi.domain.model.storage.generator.IdGenerator;
import com.softserveinc.testapi.domain.model.storage.generator.IdGeneratorImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public abstract class Storage<T extends Identifiable> {
    protected Map<Long, T> container;
    protected IdGenerator idGenerator;

    public Storage() {
        this.container = new HashMap<>();
        this.idGenerator = new IdGeneratorImpl();
    }

    public Storage(Map<Long, T> container, IdGenerator idGenerator) {
        this.container = container;
        this.idGenerator = idGenerator;
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
        if (object.getId() == null) {
            object.setId(idGenerator.generateId());
        }
        container.put(object.getId(), object);
        return object;
    }

    public T update(T object) {
        return container.compute(object.getId(), (key, value) -> value = object);
    }

    public void saveAll(List<T> objects) {
        objects.forEach(this::save);
    }
}
