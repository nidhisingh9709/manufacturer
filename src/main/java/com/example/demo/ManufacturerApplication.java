package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ManufacturerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * Supplier supplier1 = new Supplier("HM Infotech"); Supplier supplier2 = new
	 * Supplier("BS Supply"); Supplier supplier3 = new Supplier("XX Suppliers");
	 * 
	 * List<Supplier> supplier=Arrays.asList(supplier1,supplier2,supplier3);
	 * 
	 * Component component1 = new Component("Mouse", "Wireless mouse"); Component
	 * component2 = new Component("CPU", "Box size"); Component component3 = new
	 * Component("Motherboard", "#######");
	 * 
	 * List<Component> component= Arrays.asList(component1,component2,component3);
	 * 
	 * // Add tag references in the post supplier1.getComponent().add(component2);
	 * supplier1.getComponent().add(component3);
	 * supplier2.getComponent().add(component2);
	 * supplier3.getComponent().add(component1); // Add post reference in the tags
	 * component1.getSupplier().add(supplier1);
	 * component2.getSupplier().add(supplier3);
	 * component3.getSupplier().add(supplier1);
	 * 
	 * 
	 * supplierRepository.save(supplier);
	 */

}
