package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierId;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]*$")
	private String supplierName;

	@ManyToMany(fetch= FetchType.LAZY,cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "supplier_component", joinColumns = { @JoinColumn(name = "supplier_id") }, 
	inverseJoinColumns = {
			@JoinColumn(name = "component_id") 
			})
	private List<Component> component= new ArrayList<>();

	public Supplier() {

	}

	public Supplier( @NotBlank @Pattern(regexp = "^[a-zA-Z ]*$") String supplierName) {
		super();
		
		this.supplierName = supplierName;
	}
	public void addComponent(Component components) {
		component.add(components);
	}

	public int getSuuplierId() {
		return supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<Component> getComponent() {
		return component;
	}


}
