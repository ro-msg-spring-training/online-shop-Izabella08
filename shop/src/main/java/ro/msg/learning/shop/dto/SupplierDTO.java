package ro.msg.learning.shop.dto;

import lombok.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SupplierDTO {
    private Integer supplierId;
}
