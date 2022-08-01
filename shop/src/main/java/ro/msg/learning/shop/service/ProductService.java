package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.mapper.Mapper;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.repository.IProductCategoryRepository;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.repository.ISupplierRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final IProductRepository productRepository;
    private final IProductCategoryRepository productCategoryRepository;
    private final ISupplierRepository supplierRepository;
    private final Mapper mapper;

    private final ProductCategoryService productCategoryService;

    public ProductService(IProductRepository productRepository, IProductCategoryRepository productCategoryRepository, ISupplierRepository supplierRepository, Mapper mapper, ProductCategoryService productCategoryService) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.supplierRepository = supplierRepository;
        this.mapper = mapper;
        this.productCategoryService = productCategoryService;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        if(productRepository.existsById(product.getId())){
            return productRepository.save(product);
        }else{
            System.out.println("Can not find product");
            return null;
        }
    }
}
