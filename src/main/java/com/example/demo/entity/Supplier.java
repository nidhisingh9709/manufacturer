package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

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

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Supplier_component", joinColumns = { @JoinColumn(name = "supplierId") }, inverseJoinColumns = {
			@JoinColumn(name = "componentId") })
	private Set<Component> component = new HashSet<>();

	public Supplier() {

	}

	public Supplier(Integer supplierId, @NotBlank @Pattern(regexp = "^[a-zA-Z ]*$") String supplierName) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Set<Component> getComponent() {
		return component;
	}

	public void setComponent(Set<Component> component) {
		this.component = component;
	}

}
