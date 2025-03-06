package ru.zaharov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.zaharov.entity.Product;
import ru.zaharov.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {
    List<Product> findByUserId(@Param("userId") User userId);

    Optional<Product> findById(Long id);

}
