package ru.zakharov.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private Long id;
    private String acc;
    private BigDecimal balance;
    private String type;
    private User userId;
}
