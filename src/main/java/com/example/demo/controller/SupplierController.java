package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SupplierService;
import com.example.demo.entity.Supplier;

@RestController
public class SupplierController {
@Autowired
SupplierService supplierService;

@GetMapping("/supplier")
public Iterable<Supplier> getDetails() {
	return supplierService.getSupplierDetail();
}

@GetMapping("/{supplierId}/supplier")

public Optional<Supplier> getSupplierDetails(@PathVariable("supplierId") Integer supplierId) {

	return supplierService.getSupplierDetails(supplierId);
}

// create new contact
@PostMapping("/addSupplier")
@ResponseStatus(code = HttpStatus.CREATED)
public void createSupplier(@RequestBody @Valid Supplier supplier) {
	supplierService.saveSupplier(supplier);
}

// Delete Records
@DeleteMapping("/{supplierId}/deleteSupplier")
public void deleteSupplier(@PathVariable("SupplierId") Integer supplierId) {
	// TODO Auto-generated method stub
	supplierService.deleteSupplier(supplierId);
}

// update
@PutMapping("/updateSupplier")
public Supplier updateSupplier(@RequestBody Supplier supplier) {
	return supplierService.updateSupplier(supplier);

}
}
