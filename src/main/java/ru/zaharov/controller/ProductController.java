package ru.zaharov.controller;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import ru.zaharov.dto.ProductResponse;
import ru.zaharov.entity.Product;
import ru.zaharov.service.ProductService;
import ru.zaharov.service.UserService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/product")
    public ProductResponse getProductById(@RequestParam("Id") Long Id){
        Product product=productService.findById(Id);
        return new ProductResponse(Collections.singletonList(product));
    }

    @GetMapping("/user")
    public ProductResponse findByUser(@RequestParam("userId") Long userID){
        List<Product> products = productService.findByUserId(userService.findById(userID));
        return new ProductResponse(products);
    }
}
