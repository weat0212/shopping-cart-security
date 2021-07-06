package net.javaguides.springboot.springsecurity.service;

import net.javaguides.springboot.springsecurity.model.Product;
import net.javaguides.springboot.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product pd) {
        productRepository.save(pd);
    }

    @Override
    public void modify(Product pd) {
        productRepository.save(pd);
    }

    @Override
    public void deleteInfo(Long id) {
        productRepository.deleteById(id);
    }
}
