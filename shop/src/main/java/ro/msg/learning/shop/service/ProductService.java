package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.mapper.SupplierMapper;
import ro.msg.learning.shop.exception.CanNotFindProductException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductCategoryRepository;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.repository.ISupplierRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final IProductRepository productRepository;


    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
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
            throw new CanNotFindProductException("Can not find product");
        }
    }
}
