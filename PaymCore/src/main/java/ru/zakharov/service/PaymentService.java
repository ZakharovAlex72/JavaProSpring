package ru.zakharov.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.zakharov.dto.*;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductResponse getProductsByUser(Long userId) {
        Map<String, String> params = Collections.singletonMap("user", String.valueOf(userId));
        return restTemplate.getForObject("/user?userId={user}", ProductResponse.class,params);
    }

    public ProductResponse getProduct(Long productId) {
        Map<String,String> params= Collections.singletonMap("product", String.valueOf(productId));
        return restTemplate.getForObject("/product?id={product}",ProductResponse.class,params);
    }

    public ProductResponse execute(Long productId, BigDecimal summa) {
        ProductResponse product = getProduct(productId);
        if (product.products().get(0).getBalance().compareTo(summa) < 0) {
            throw new IntegrationException(new IntegrationErrorDto("402 PAYMENT_DECLINED","Недостаточно средств на счете для оплаты"));
        }
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(product.products().get(0).getId()));
        params.put("summa", String.valueOf(product.products().get(0).getBalance().subtract(summa)));
        restTemplate.postForObject("/execute?prod_id={id}&balance={summa}",null,Product.class,params);
        return  getProduct(productId);
    }


}
