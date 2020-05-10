package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> findAll();
	public void save(EmployeeEntity employeeEntity);
	public EmployeeEntity findById(int id);
	public void delete(int id);
}
