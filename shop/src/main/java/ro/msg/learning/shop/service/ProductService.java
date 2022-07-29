package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.mapper.Mapper;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductCategoryRepository;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.repository.ISupplierRepository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final IProductRepository productRepository;
    private final IProductCategoryRepository productCategoryRepository;
    private final ISupplierRepository supplierRepository;
    private final Mapper mapper;

    public ProductService(IProductRepository productRepository, IProductCategoryRepository productCategoryRepository, ISupplierRepository supplierRepository, Mapper mapper) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.supplierRepository = supplierRepository;
        this.mapper = mapper;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public ProductDTO createProductUsingDTO(ProductDTO productDTO){
        Product product = mapper.dtoToProduct(productDTO);
        return mapper.productToDto(productRepository.save(product));
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

}
