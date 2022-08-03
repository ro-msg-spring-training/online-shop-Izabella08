package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.mapper.ProductMapper;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.ProductService;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    private ProductMapper productMapper = new ProductMapper();

    @GetMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping(value="/new_product")
    private ResponseEntity<Object> createProduct(@RequestBody ProductDTO productDTO){
        Product product = productMapper.DTOToProduct(productDTO);
        productService.createProduct(product);
        return new ResponseEntity<>("Product created successfully!", HttpStatus.CREATED);
    }

    @GetMapping(value="/get_by_id/{id}")
    private Optional<Product> getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @DeleteMapping(value="/delete_product/{id}")
    private ResponseEntity<Object> deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }

    @PutMapping("/update_product/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Integer id)
    {
        Product product = productMapper.DTOToProduct(productDTO);
        productService.updateProduct(product);
        return new ResponseEntity<>("Product edited successfully!", HttpStatus.OK);
    }
}
