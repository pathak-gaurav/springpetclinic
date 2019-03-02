package com.gaurav.springpetclinic;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T object);

    Set<T> findAll();

    void deleteById(ID id);

    void delete(T object);
}
