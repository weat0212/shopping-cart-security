package net.javaguides.springboot.springsecurity.service;

import net.javaguides.springboot.springsecurity.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save( Product pd);
    void modify(Product pd);
}
