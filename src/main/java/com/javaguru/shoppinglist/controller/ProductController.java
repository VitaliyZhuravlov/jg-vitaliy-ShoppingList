package com.javaguru.shoppinglist.controller;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public ProductDto addProduct(@RequestBody ProductDto product) {
        return service.save(product);
    }

    @GetMapping("/all")
    public List<ProductEntity> findAllProducts() {
        return service.findAll();
    }

    @GetMapping("/productById/{id}")
    public ProductEntity findProductById(@PathVariable Long id) {
        return service.findProductById(id);
    }

    @GetMapping("/product/{name}")
    public ProductEntity findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public ProductEntity update(@RequestBody ProductEntity product) {
        return service.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return service.delete(id);
    }
}
