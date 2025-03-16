package ru.zakharov.controller;


import org.springframework.web.bind.annotation.*;
import ru.zakharov.dto.ProductResponse;
import ru.zakharov.service.PaymentService;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/pay")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping("/products")
    public ProductResponse getProducts(@RequestParam("userId")  Long userId) {
        ProductResponse products = paymentService.getProductsByUser(userId);
        return products;
    }

    @GetMapping("/product")
    public ProductResponse getProduct(@RequestParam("productId") Long productId){
        ProductResponse product =paymentService.getProduct(productId);
        return product;
    }

    @PostMapping(value = "/execute")
    public ProductResponse execute(@RequestParam("productId") Long productId, @RequestParam("amount") BigDecimal amount){
        ProductResponse result = paymentService.execute(productId, amount);
        return result;
    }


}
