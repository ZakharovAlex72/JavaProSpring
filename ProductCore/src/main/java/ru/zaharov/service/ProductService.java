package ru.zaharov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zaharov.dto.NoDataFoundException;
import ru.zaharov.dto.ProductResponse;
import ru.zaharov.entity.Product;
import ru.zaharov.entity.User;
import ru.zaharov.repository.ProductRepository;
import ru.zaharov.repository.UserRepository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    public final ProductRepository productRepository;
    public final UserRepository userRepository;

    public ProductResponse findById(Long id) {
        Product product =  productRepository.findById(id).
                orElseThrow(() -> new NoDataFoundException("Продукт не найден", "NOT_FOUND"));
        return new ProductResponse(Collections.singletonList(product));
    }

    public  List<Product> findByUserId(User userId){
        return productRepository.findByUserId(userId);
    }

    public void updateBalance(Long id, BigDecimal balance){
        productRepository.updateBalance(id,balance);
    }
}
