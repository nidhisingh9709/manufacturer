package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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


	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="product_id", referencedColumnName="productId")
	private Product product;
	
	@ManyToMany(mappedBy="component")
	private List<Supplier> supplier=new ArrayList<>();
	
	public Component() {
		
		
	}

	public Component( @NotBlank @Pattern(regexp = "^[a-zA-Z 0-9]*$") String componentName,
			@NotBlank @Size(max = 50) String description) {
		super();
		this.componentName = componentName;
		this.description = description;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Supplier> getSupplier() {
		return supplier;
	}

	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}



	

	

}
