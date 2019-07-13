package com.dilip.security.service;

import java.util.List;

import com.dilip.security.entity.EmployeeEntity;

public interface IEmployeeService {

	public EmployeeEntity getEmployee(String id);

	public EmployeeEntity createEmployee(EmployeeEntity employee);

	public List<EmployeeEntity> findEmployee();

	public List<EmployeeEntity>  findEmployeeById(int id,int offSet,int limit);
	
	public int addData(int a,int b,int c);
}
