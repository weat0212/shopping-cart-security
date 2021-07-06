package net.javaguides.springboot.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import net.javaguides.springboot.springsecurity.model.Product;
import net.javaguides.springboot.springsecurity.service.ProductService;
import net.javaguides.springboot.springsecurity.web.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController()
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 產品列表
     */
    @GetMapping(value = "/products")
    public List<Product> getProductInformation(HttpServletRequest req) {
        List<Product> all = productService.findAll();
        return all;
    }

    /**
     * 使用ID取得產品資訊
     */
    @GetMapping(value = "/products/{id}")
    public Product getProductInformationById(HttpServletRequest req, @PathVariable(name = "id") Long id) {
        Optional<Product> data = productService.findById(id);
        Product product = data.get();
        return product;
    }

    /**
     * 建立產品
     */
    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result creatNewProduct(@RequestBody ProductDto productDto) {
        Product pd = new Product();
        pd.setProduct(productDto.getProduct());
        pd.setPrice(productDto.getPrice());
        pd.setInventory(productDto.getInventory());

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        pd.setCreateTime(timestamp);
        pd.setUpdateTime(timestamp);
        productService.save(pd);
        log.debug("New Product Created!");
        return null;
    }

    /**
     * 修改產品資訊
     */
    @PutMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result productInfo(@PathVariable(value = "id") Long id, @RequestBody ProductDto productDto) throws Exception {

        if(id == null){
            throw new Exception("ID Not Found");
        }
        Optional<Product> data = productService.findById(id);
        Product product = data.get();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        product.setUpdateTime(timestamp);
        product.setInventory(productDto.getInventory());
        product.setProduct(productDto.getProduct());
        product.setPrice(productDto.getPrice());

        productService.modify(product);
        log.debug("Modified product id: " + id);

        return null;
    }


    /**
     * 使用id刪除產品資訊
     */
    @DeleteMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result deleteProduct(@PathVariable(value = "id") Long id) {
        log.debug("deleting product id: " + id);
        productService.deleteInfo(id);
        return null;
    }


}
