package ru.zaharov.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zaharov.entity.Product;
import ru.zaharov.entity.User;
import ru.zaharov.repository.ProductRepository;
import ru.zaharov.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    public final ProductRepository productRepository;
    public final UserRepository userRepository;


    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Product> findByUserId(User userId){
        return productRepository.findByUserId(userId);
    }
}
