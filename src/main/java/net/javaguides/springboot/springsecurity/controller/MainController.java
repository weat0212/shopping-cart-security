package net.javaguides.springboot.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import net.javaguides.springboot.springsecurity.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    /**
     * 取得產品資訊
     * @param model
     * @return
     */
    @GetMapping(value = "/products")
    public String getProductInformation(Model model) {
        log.debug("Getting Products Information Page...");
        model.addAttribute("product", productService.findAll());
        return "product_list";
    }
}
