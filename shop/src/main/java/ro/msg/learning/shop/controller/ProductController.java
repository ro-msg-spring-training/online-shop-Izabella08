package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.ProductService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping(value="/create_product")
    private ResponseEntity<Object> createProduct(@RequestBody ProductDTO product){
        productService.createProductUsingDTO(product);
        return new ResponseEntity<>("Product created successfully!", HttpStatus.CREATED);
    }

    @GetMapping(value="/product/{id}")
    private void getProductById(@PathVariable Integer id){
        productService.getProductById(id);
    }

    @DeleteMapping(value="/product/{id}")
    private void deleteProductById(Integer id){
        productService.deleteProductById(id);
    }


}
