package net.javaguides.springboot.springsecurity.controller;


import net.javaguides.springboot.springsecurity.model.Product;
import net.javaguides.springboot.springsecurity.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        Object[] controllers;
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void getProductInformationById() throws Exception {

        Product product = new Product();
        product.setId(1L);
        product.setProduct("Apple");
        product.setPrice(15);
        product.setInventory(100);

        when(productService.findById(anyLong())).thenReturn(java.util.Optional.of(product));

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("product"));
    }

    @Test
    void creatNewProduct() {
    }

    @Test
    void productInfo() {
    }

    @Test
    void deleteProduct() {
    }
}