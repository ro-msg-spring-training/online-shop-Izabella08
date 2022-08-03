package ro.msg.learning.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductDTO {
    private Integer productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private Double productWeight;
    private ProductCategoryDTO productCategory;
    private SupplierDTO supplier;
    private String productImageUrl;

}
