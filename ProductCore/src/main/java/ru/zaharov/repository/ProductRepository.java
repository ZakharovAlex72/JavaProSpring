package ru.zaharov.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.zaharov.entity.Product;
import ru.zaharov.entity.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {
    List<Product> findByUserId(@Param("userId") User userId);

    Optional<Product> findById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update products set balance = :balance where id = :id", nativeQuery = true)
    void updateBalance(@Param("id") Long prodId, @Param("balance") BigDecimal balance);
}
