package net.javaguides.springboot.springsecurity.web.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String product;
    private int price;
    private int inventory;

}
