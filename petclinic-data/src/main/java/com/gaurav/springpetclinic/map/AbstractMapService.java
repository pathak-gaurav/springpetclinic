package com.gaurav.springpetclinic.map;

import com.gaurav.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(x -> x.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        Long nextVal = null;
        try {
            nextVal = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException exe) {
            nextVal = 1L;
        }
        return nextVal;
    }

}
