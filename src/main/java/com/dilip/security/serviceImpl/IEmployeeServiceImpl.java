package com.dilip.security.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dilip.security.entity.EmployeeEntity;
import com.dilip.security.repository.EmployeeRepository;
import com.dilip.security.repository.IEmployeeRepository;
import com.dilip.security.service.IEmployeeService;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepository iEmployeeRepositor;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public EmployeeEntity getEmployee(String id) {

		return iEmployeeRepositor.findCustomByDomain(id);

	}

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employee) {

		Pageable pageable = PageRequest.of(1, 10);
		Page<EmployeeEntity> page = iEmployeeRepositor.findAll(pageable);

		if (page != null) {
			page.forEach(p -> System.out.println(p));
		}
		System.out.println(page);
		List<EmployeeEntity> findAll = iEmployeeRepositor.findAll();

		return iEmployeeRepositor.insert(employee);

	}

	@Override
	public List<EmployeeEntity> findEmployee() {
		Query query = new Query();
		Query addCriteria = query.addCriteria(Criteria.where("firstName").is("dilip"));

		mongoTemplate.find(addCriteria, EmployeeEntity.class);
		return null;
	}

	@Override
	public List<EmployeeEntity> findEmployeeById(int id, int offSet, int limit) {
		System.out.println(offSet + "\t" + limit);

		Pageable pageable = PageRequest.of(offSet, limit, Direction.ASC, "firstName");
		Page<EmployeeEntity> findById = employeeRepository.findByfirstName("dilip", pageable);

		System.out.println(
				findById.getSize() + " offset" + pageable.getOffset() + "PageNuber" + pageable.getPageNumber());
		for (EmployeeEntity findById1 : findById) {
			System.out.println(findById1);
		}
		Stream<EmployeeEntity> stream = findById.get();
		return (List<EmployeeEntity>) stream.collect(Collectors.toList());

	}

	@Override
	public int addData(int a, int b, int c) {
		int sum = 0;
		if (a > 1) {
			a = 30;
		}
		if (b > 1) {
			b = 90;
		}
		if (c > 1) {
			c = 60;
		}
		sum = a + b + c;
		return sum;
	}
}
