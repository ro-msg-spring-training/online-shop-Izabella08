package ro.msg.learning.shop.controller;
import ch.qos.logback.core.status.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.mapper.ProductMapper;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<Product> productEntitiesAfterSave = productService.getAllProducts();
        List<ProductDTO> productDTOListAfterSave = new ArrayList<>();
        productEntitiesAfterSave.forEach(
                product -> {
                    ProductDTO productDTOAfterSave = productMapper.productToDTO(product);
                    productDTOListAfterSave.add(productDTOAfterSave);
                }
        );
        return new ResponseEntity<>(productDTOListAfterSave, HttpStatus.OK);
    }

    @PostMapping(value="/new-product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTOFromFE){
        Product productEntityForService = productMapper.DTOToProduct(productDTOFromFE);
        Product productEntityAfterSave = productService.createProduct(productEntityForService);
        ProductDTO productDTOAfterSave = productMapper.productToDTO(productEntityAfterSave);

        return new ResponseEntity<>(productDTOAfterSave, HttpStatus.CREATED);
    }

    @GetMapping(value="/get-by-id/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        Product product  = productService.getProductById(id);
        ProductDTO productDTO = productMapper.productToDTO(product);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/delete-product/{id}")
    public ResponseEntity<Status> deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTOFromFE, @PathVariable Integer id)
    {
        Product productEntityForService = productMapper.DTOToProduct(productDTOFromFE);
        Product productEntityAfterSave = productService.updateProduct(productEntityForService);
        ProductDTO productDTOAfterSave = productMapper.productToDTO(productEntityAfterSave);
        return new ResponseEntity<>(productDTOAfterSave, HttpStatus.OK);
    }
}
