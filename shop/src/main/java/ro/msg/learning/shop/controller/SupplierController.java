package ro.msg.learning.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.dto.mapper.SupplierMapper;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.service.SupplierService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SupplierController {
    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;

    public SupplierController(SupplierService supplierService, SupplierMapper supplierMapper) {
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
    }

    @PostMapping(value="/supplier")
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTOFromFE) {

        Supplier supplierEntityForService = supplierMapper.DTOToSupplier(supplierDTOFromFE);
        Supplier supplierEntityAfterSave = supplierService.createSupplier(supplierEntityForService);
        SupplierDTO supplierDTOAfterSave = supplierMapper.supplierToDTO(supplierEntityAfterSave);

        return new ResponseEntity<>(supplierDTOAfterSave, HttpStatus.CREATED);
    }

    @GetMapping(value = "/suppliers")
    public ResponseEntity<List<SupplierDTO>> getSuppliers() {
        List<Supplier> supplierEntitiesAfterSave = supplierService.getAllSuppliers();
        List<SupplierDTO> supplierDTOListAfterSave = new ArrayList<>();
        supplierEntitiesAfterSave.forEach(
                supplier -> {
                    SupplierDTO supplierDTOAfterSave = supplierMapper.supplierToDTO(supplier);
                    supplierDTOListAfterSave.add(supplierDTOAfterSave);
                }
        );

        return new ResponseEntity<>(supplierDTOListAfterSave, HttpStatus.OK);
    }

    @GetMapping(value="/get-supplier-by-id/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Integer id){

        Supplier supplier = supplierService.getSupplierById(id);
        SupplierDTO supplierDTO = supplierMapper.supplierToDTO(supplier);

        return new ResponseEntity<>(supplierDTO, HttpStatus.OK);
    }
}
