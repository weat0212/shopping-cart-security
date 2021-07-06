package net.javaguides.springboot.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import net.javaguides.springboot.springsecurity.service.OrderingService;
import net.javaguides.springboot.springsecurity.service.ProductService;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class OrderingController {

    @Autowired
    private final OrderingService orderingService;

    @Autowired
    private final UserService userService;

    @Autowired
    private final ProductService productService;

    public OrderingController(OrderingService orderingService, UserService userService, ProductService productService) {
        this.orderingService = orderingService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping(value = "/purchase")
    public String purchase(@ModelAttribute("purchased") @Valid ProductDto productDto, BindingResult result) {


        return "purchase";
    }
}
