package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;

	@NotBlank
	@Size(max = 15)
	@Column(name = "product_name")
	private String productName;

	@Pattern(regexp = "^[0-9]*$")
	@Range(min = 1, max = 100)
	@Column(name = "Quantity_on_hand")
	private String quantityOnHand;

	public Product() {

	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "product")
	private Set<Component> component = new HashSet<>();

	public Product(Integer product_id, @NotBlank @Size(max = 15) String productName,
			@Pattern(regexp = "^[0-9]*$") @Range(min = 1, max = 100) String quantityOnHand) {
		super();
		this.product_id = product_id;
		this.productName = productName;
		this.quantityOnHand = quantityOnHand;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(String quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public Set<Component> getComponent() {
		return component;
	}

	public void setComponent(Set<Component> component) {
		this.component = component;
	}

}
