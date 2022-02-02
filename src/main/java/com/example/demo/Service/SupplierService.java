package com.example.demo.Service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository supplierRepository;

	public Iterable<Supplier> getSupplierDetail() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

	public Optional<Supplier> getSupplierDetails(Integer supplierId) {
		// TODO Auto-generated method stub
		return supplierRepository.findById(supplierId);
	}

	@Transactional
	public void saveSupplier(@Valid Supplier supplier) {
		// TODO Auto-generated method stub
		supplierRepository.save(supplier);
	}

	@Transactional
	public void deleteSupplier(Integer supplierId) {
		// TODO Auto-generated method stub
		supplierRepository.deleteById(supplierId);
	}

	@Transactional
	public Supplier updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierRepository.save(supplier);
	}

}
