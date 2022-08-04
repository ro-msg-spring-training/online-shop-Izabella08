package ro.msg.learning.shop.dto.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;

@Component
public class ProductMapper {
    private final SupplierMapper supplierMapper;
    private final ProductCategoryMapper productCategoryMapper;

    public ProductMapper(SupplierMapper supplierMapper, ProductCategoryMapper productCategoryMapper) {
        this.supplierMapper = supplierMapper;
        this.productCategoryMapper = productCategoryMapper;
    }

    public Product DTOToProduct(ProductDTO productDto) {
        Product newProduct = Product.builder()
                .name(productDto.getProductName())
                .description(productDto.getProductDescription())
                .price(productDto.getProductPrice())
                .weight(productDto.getProductWeight())
                .category(productCategoryMapper.DTOToProductCategory(productDto.getProductCategory()))
                .supplier(supplierMapper.DTOToSupplier(productDto.getSupplier()))
                .imageUrl(productDto.getProductImageUrl())
                .build();
        newProduct.setId(productDto.getProductId());
        return newProduct;
    }

    public ProductDTO productToDTO(Product product) {
        return ProductDTO.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productDescription(product.getDescription())
                .productPrice(product.getPrice())
                .productWeight(product.getWeight())
                .supplier(supplierMapper.supplierToDTO(product.getSupplier()))
                .productCategory(productCategoryMapper.productCategoryToDTO(product.getCategory()))
                .productImageUrl(product.getImageUrl())
                .build();
    }

}
