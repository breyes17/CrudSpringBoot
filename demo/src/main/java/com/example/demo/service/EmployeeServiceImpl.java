package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<EmployeeEntity> findAll() {
		
		return employeeRepository.findAll();
	}


	@Override
	public void save(EmployeeEntity employeeEntity) {
		employeeRepository.save(employeeEntity);
	}


	@Override
	public EmployeeEntity findById(int id) {
		
		Optional<EmployeeEntity> result = employeeRepository.findById(id);
		
		EmployeeEntity emp = null;
		
		if(result != null) {
			emp = result.get();
		} else {
			throw new RuntimeException("Not found "+id);
		}
		
		return emp; 
	}


	@Override
	public void delete(int id) {

		employeeRepository.deleteById(id);
	}



}
