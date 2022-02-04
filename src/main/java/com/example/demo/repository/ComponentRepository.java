package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Component;
import com.example.demo.entity.Supplier;

@Repository
public interface ComponentRepository extends CrudRepository<Component, Integer> {

	public void save(List<Component> component);

}
