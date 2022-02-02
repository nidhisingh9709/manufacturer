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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Component {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer componentId;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z 0-9]*$")
	@Column(name = "Component_name")
	private String componentName;

	@Size(max = 50)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Component_Product", joinColumns = { @JoinColumn(name = "componentId") }, inverseJoinColumns = {
			@JoinColumn(name = "productId") })
	private Set<Product> product = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "component")
	private Set<Supplier> supplier = new HashSet<>();

	public Component(Integer componentId, @NotBlank @Pattern(regexp = "^[a-zA-Z 0-9]*$") String componentName,
			@NotBlank @Size(max = 50) String description) {
		super();
		this.componentId = componentId;
		this.componentName = componentName;
		this.description = description;
	}

	public Integer getComponentId() {
		return componentId;
	}

	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Set<Supplier> getSupplier() {
		return supplier;
	}

	public void setSupplier(Set<Supplier> supplier) {
		this.supplier = supplier;
	}

}
