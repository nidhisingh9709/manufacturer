package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

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

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "product")
	private List<Component> component;

	public Product(@NotBlank @Size(max = 15) String productName,
			@Pattern(regexp = "^[0-9]*$") @Range(min = 1, max = 100) String quantityOnHand) {
		super();
		this.productName = productName;
		this.quantityOnHand = quantityOnHand;
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

	public List<Component> getComponent() {
		return component;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}

}
