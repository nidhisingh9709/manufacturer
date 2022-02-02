package com.example.demo.Service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Component;
import com.example.demo.repository.ComponentRepository;

@Service
public class ComponentService {

	@Autowired
	ComponentRepository componentRepository;

	public Iterable<Component> getComponentDetail() {
		// TODO Auto-generated method stub
		return componentRepository.findAll();
	}

	public Optional<Component> getComponentDetails(Integer componentId) {
		// TODO Auto-generated method stub
		return componentRepository.findById(componentId);
	}

	public void saveComponent(@Valid Component component) {
		// TODO Auto-generated method stub
		componentRepository.save(component);
	}

	public void deleteComponent(Integer componentId) {
		// TODO Auto-generated method stub
		componentRepository.deleteById(componentId);
	}

	public Component updateComponent(Component component) {
		// TODO Auto-generated method stub
		return componentRepository.save(component);
	}
}
