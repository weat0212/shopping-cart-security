package net.javaguides.springboot.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class GorestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/showGorestApi")
    public String showGorestApi() throws IOException {
        String apiURL = "https://gorest.co.in/public-api/users";
        return restTemplate.getForObject(apiURL,String.class);
    }
}
