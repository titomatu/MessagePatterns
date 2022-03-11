package io.tamatu.messagepatterns.controller;

import io.tamatu.messagepatterns.model.Product;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProducerTemplate producerTemplate;

    @GetMapping("/products/{category}")
    @ResponseBody
    public List<Product> filterProductsByCategory(@PathVariable("category") final String category){
        producerTemplate.start();
        List<Product> products = producerTemplate.requestBody(
                "direct:fetchProducts", category, List.class);
        producerTemplate.stop();

        return products;
    }
}
