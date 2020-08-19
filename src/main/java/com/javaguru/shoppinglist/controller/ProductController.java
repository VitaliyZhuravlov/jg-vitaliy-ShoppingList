package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto addProduct(@Valid @RequestBody ProductDto product) {
        return service.save(product);
    }

    @GetMapping("/all")
    public ArrayList<ProductDto> findAllProducts() {
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return service.findProductById(id);
    }

    @GetMapping("/{name}")
    public ProductDto findProductByName(@PathVariable String name) {
        return service.findProductByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update")
    public void update(@Valid @RequestBody ProductDto product) {
        service.update(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public void handleNotFound(ProductNotFoundException exception) {
        System.out.println(exception.getMessage());
    }
}
