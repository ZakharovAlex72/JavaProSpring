package ru.zaharov.dto;

import ru.zaharov.entity.Product;

import java.util.List;

public record ProductResponse(List<Product> products) {
}
