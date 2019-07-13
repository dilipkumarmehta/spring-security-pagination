package com.dilip.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.security.entity.EmployeeEntity;
import com.dilip.security.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService iEmployeeService;

	@GetMapping("/rest/employee/{id}")
	public EmployeeEntity getEmployee(@PathVariable("id") String idValue) {
		return iEmployeeService.getEmployee(idValue);

	}

	@RequestMapping("/rest/create")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
		return iEmployeeService.createEmployee(employee);

	}

	@GetMapping("/rest/findemp")
	public List<EmployeeEntity> findEmployee() {
		return iEmployeeService.findEmployee();

	}
//http://localhost:8087/rest/find?id=122&offset=10&limit=20
	@GetMapping("/rest/find")
	public List<EmployeeEntity> findEmployeeById(@RequestParam("id") int id,@RequestParam("offset") int offser,@RequestParam("limit") int limit) {
		return iEmployeeService.findEmployeeById(id, offser, limit);

	}

}
