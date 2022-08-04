package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.repository.IProductCategoryRepository;

import java.util.List;

@Service
public class ProductCategoryService {
    private final IProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(IProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public ProductCategory createCategory(ProductCategory productCategory){
        return productCategoryRepository.save(productCategory);
    }

    public List<ProductCategory> getAllProductCategories(){
        return productCategoryRepository.findAll();
    }

    public ProductCategory getCategoryById(Integer id){
        return productCategoryRepository.findById(id).get();
    }
}
