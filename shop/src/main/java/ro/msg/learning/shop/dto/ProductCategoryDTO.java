package ro.msg.learning.shop.dto;

import lombok.*;

@Builder
@Data
public class ProductCategoryDTO {
    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
}
