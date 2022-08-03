package ro.msg.learning.shop.dto.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.model.ProductCategory;

@Component
public class ProductCategoryMapper {

    public ProductCategory DTOToProductCategory(ProductCategoryDTO productCategoryDto) {
        ProductCategory newProd = ProductCategory.builder()
                .name(productCategoryDto.getCategoryName())
                .description(productCategoryDto.getCategoryDescription())
                .build();
        newProd.setId(productCategoryDto.getCategoryId());
        return newProd;
    }
}
