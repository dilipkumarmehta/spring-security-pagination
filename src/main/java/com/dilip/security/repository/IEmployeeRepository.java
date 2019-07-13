package com.dilip.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dilip.security.entity.EmployeeEntity;

@Repository
public interface IEmployeeRepository extends MongoRepository<EmployeeEntity, String> {
	
	@Query("{domain:'?0'}")
	EmployeeEntity findCustomByDomain(String domain);

}
