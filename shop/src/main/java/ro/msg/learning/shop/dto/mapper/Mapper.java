package ro.msg.learning.shop.dto.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.model.Supplier;


@Component
public class Mapper {

    public ProductCategoryDTO productCategoryToDTO(ProductCategory productCategory) {
        return ProductCategoryDTO.builder()
                .categoryId(productCategory.getId())
                .categoryName(productCategory.getName())
                .categoryDescription(productCategory.getDescription())
                .build();
    }

    public ProductCategory DTOToProductCategory(ProductCategoryDTO productCategoryDto) {
        ProductCategory newProd = ProductCategory.builder()
                .name(productCategoryDto.getCategoryName())
                .description(productCategoryDto.getCategoryDescription())
                .build();
        newProd.setId(productCategoryDto.getCategoryId());
        return newProd;
    }

    public SupplierDTO supplierToDTO(Supplier supplier) {
        return SupplierDTO.builder()
                .supplierId(supplier.getId())
                .supplierName(supplier.getName())
                .build();
    }

    public Supplier DTOToSupplier(SupplierDTO supplierDto) {
        Supplier newSupplier = Supplier.builder()
                .name(supplierDto.getSupplierName())
                .build();
        newSupplier.setId(supplierDto.getSupplierId());
        return newSupplier;
    }

    public ProductDTO productToDTO(Product product) {
        return ProductDTO.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productDescription(product.getDescription())
                .productPrice(product.getPrice())
                .productWeight(product.getWeight())
                .supplier(this.supplierToDTO(product.getSupplier()))
                .productCategory(this.productCategoryToDTO(product.getCategory()))
                .productImageUrl(product.getImageUrl())
                .build();
    }

    public Product DTOToProduct(ProductDTO productDto) {
        Product newProduct = Product.builder()
                .name(productDto.getProductName())
                .description(productDto.getProductDescription())
                .price(productDto.getProductPrice())
                .weight(productDto.getProductWeight())
                .category(this.DTOToProductCategory(productDto.getProductCategory()))
                .supplier(this.DTOToSupplier(productDto.getSupplier()))
                .imageUrl(productDto.getProductImageUrl())
                .build();
        newProduct.setId(productDto.getProductId());
        return newProduct;
    }


}
