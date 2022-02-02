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

import com.example.demo.Service.ComponentService;
import com.example.demo.entity.Component;


@RestController
public class ComponentController {

	@Autowired
	ComponentService componentService;
	
	
	@GetMapping("/component")
	public Iterable<Component> getDetails() {
		return componentService.getComponentDetail();
	}

	@GetMapping("/{componentId}/component")

	public Optional<Component> getComponentDetails(@PathVariable("componentId") Integer componentId) {

		return componentService.getComponentDetails(componentId);
	}

	// create new contact
	@PostMapping("/addcomponent")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createComponent(@RequestBody @Valid Component component) {
		componentService.saveComponent(component);
	}

	// Delete Records
	@DeleteMapping("/{componentId}/deletecomponent")
	public void deleteComponent(@PathVariable("componentId") Integer componentId) {
		// TODO Auto-generated method stub
		componentService.deleteComponent(componentId);
	}

	// update
	@PutMapping("/updateComponent")
	public Component updateComponent(@RequestBody Component component) {
		return componentService.updateComponent(component);

	}
}
