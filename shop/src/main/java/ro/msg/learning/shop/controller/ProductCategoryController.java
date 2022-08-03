package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.service.ProductCategoryService;

import java.util.Optional;

@RestController
public class ProductCategoryController {
    @Autowired
    private final ProductCategoryService categoryService;

    public ProductCategoryController(ProductCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value="/category")
    public ResponseEntity<Object> createCategory(@RequestBody ProductCategory productCategory) {
        categoryService.createCategory(productCategory);
        return new ResponseEntity<>("Category created successfully!", HttpStatus.CREATED);
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<Object> getCategories() {
        return new ResponseEntity<>(categoryService.getAllProductCategories(), HttpStatus.OK);
    }

    @GetMapping(value="/get_category_by_id/{id}")
    public Optional<ProductCategory> getCategoryById(@PathVariable  Integer id){
        return categoryService.getCategoryById(id);
    }
}
