package ro.msg.learning.shop.dto.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.model.Supplier;


@Component
public class SupplierMapper {

    public Supplier DTOToSupplier(SupplierDTO supplierDto) {
        Supplier newSupplier = Supplier.builder()
                .name(supplierDto.getSupplierName())
                .build();
        newSupplier.setId(supplierDto.getSupplierId());
        return newSupplier;
    }

}
