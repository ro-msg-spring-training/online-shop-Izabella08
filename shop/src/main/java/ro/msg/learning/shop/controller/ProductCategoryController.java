package ro.msg.learning.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.dto.mapper.ProductCategoryMapper;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.service.ProductCategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductCategoryController {
    private final ProductCategoryService categoryService;
    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryController(ProductCategoryService categoryService, ProductCategoryMapper productCategoryMapper) {
        this.categoryService = categoryService;
        this.productCategoryMapper = productCategoryMapper;
    }

    @PostMapping(value="/category")
    public ResponseEntity<ProductCategoryDTO> createCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {

        ProductCategory productCategoryForService = productCategoryMapper.DTOToProductCategory(productCategoryDTO);
        ProductCategory productCategoryEntityAfterSave = categoryService.createCategory(productCategoryForService);
        ProductCategoryDTO productDTOAfterSave = productCategoryMapper.productCategoryToDTO(productCategoryEntityAfterSave);

        return new ResponseEntity<>(productDTOAfterSave, HttpStatus.CREATED);
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<List<ProductCategoryDTO>> getCategories() {
        List<ProductCategory> productCategoryEntitiesAfterSave = categoryService.getAllProductCategories();
        List<ProductCategoryDTO> productCategoryDTOListAfterSave = new ArrayList<>();
        productCategoryEntitiesAfterSave.forEach(
                product -> {
                    ProductCategoryDTO productDTOAfterSave = productCategoryMapper.productCategoryToDTO(product);
                    productCategoryDTOListAfterSave.add(productDTOAfterSave);
                }
        );
        return new ResponseEntity<>(productCategoryDTOListAfterSave, HttpStatus.OK);
    }

    @GetMapping(value="/get-category-by-id/{id}")
    public ResponseEntity<ProductCategoryDTO> getCategoryById(@PathVariable  Integer id){

        ProductCategory productCategory = categoryService.getCategoryById(id);
        ProductCategoryDTO productCategoryDTO = productCategoryMapper.productCategoryToDTO(productCategory);
        return new ResponseEntity<>(productCategoryDTO, HttpStatus.OK);
    }
}
