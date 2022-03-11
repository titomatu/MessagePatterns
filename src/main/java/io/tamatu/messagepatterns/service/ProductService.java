package io.tamatu.messagepatterns.service;

import io.tamatu.messagepatterns.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    public List<Product> filterByCategory(String category){
        List<Product> products = Arrays.asList(
                new Product("product 1", "category 1"),
                new Product("product 2", "category 2")
        );

        return products.stream().filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
