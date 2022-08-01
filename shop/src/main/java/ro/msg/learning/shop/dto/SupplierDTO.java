package ro.msg.learning.shop.dto;

import lombok.*;

@Builder
@Data
public class SupplierDTO {
    private Integer supplierId;
    private String supplierName;
}
