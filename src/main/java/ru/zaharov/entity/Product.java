package ru.zaharov.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product {
    //id, номер счета, баланс, тип продукта (счет, карта), userId.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "acc")
    private String acc;

    @Column(name="balance")
    private BigDecimal balance;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    public Product(Long id, String acc, BigDecimal balance, String type, User userId) {
        this.id = id;
        this.acc = acc;
        this.balance = balance;
        this.type = type;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", acc='" + acc + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                ", userId=" + userId +
                '}';
    }
}
