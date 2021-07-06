package net.javaguides.springboot.springsecurity.service;

import net.javaguides.springboot.springsecurity.model.Ordering;

import java.util.List;
import java.util.Optional;

public interface OrderingService {

    List<Ordering> findAll();
    Optional<Ordering> findById(Long id);
    void save(Ordering ordering);
    void modify(Ordering ordering);
    void delete(Long id);
}
