package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.repository.ISupplierRepository;

import java.util.List;

@Service
public class SupplierService {
    private final ISupplierRepository supplierRepository;

    public SupplierService(ISupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier createSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer id){
        return supplierRepository.findById(id).get();
    }

}
