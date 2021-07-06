package net.javaguides.springboot.springsecurity.bootstrap;

import net.javaguides.springboot.springsecurity.model.Product;
import net.javaguides.springboot.springsecurity.repository.ProductRepository;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
@Profile("default")
public class ProductBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;

    public ProductBootstrap(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (productRepository.count() == 0L) {
            log.debug("Loading Products");
            loadProducts();
        }
    }

    private void loadProducts() {

        Product product1 = new Product();
        product1.setProduct("蘋果");
        product1.setPrice(10);
        product1.setInventory(1000);
        product1.setCreateTime(new Timestamp(System.currentTimeMillis()));
        product1.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProduct("香蕉");
        product2.setPrice(12);
        product2.setInventory(1000);
        product2.setCreateTime(new Timestamp(System.currentTimeMillis()));
        product2.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProduct("西瓜");
        product3.setPrice(20);
        product3.setInventory(1000);
        product3.setCreateTime(new Timestamp(System.currentTimeMillis()));
        product3.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product3);
    }
}
