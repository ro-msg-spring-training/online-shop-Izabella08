package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.service.SupplierService;

import java.util.Optional;

@RestController
public class SupplierController {
    @Autowired
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping(value="/supplier")
    private ResponseEntity<Object> createSupplier(@RequestBody Supplier supplier) {
        supplierService.createSupplier(supplier);
        return new ResponseEntity<>("Supplier created successfully!", HttpStatus.CREATED);
    }

    @GetMapping(value = "/suppliers")
    public ResponseEntity<Object> getSuppliers() {
        return new ResponseEntity<>(supplierService.getAllSuppliers(), HttpStatus.OK);
    }

    @GetMapping(value="/supplier/{id}")
    private Optional<Supplier> getSupplierById(@PathVariable Integer id){
        return supplierService.getSupplierById(id);
    }
}
