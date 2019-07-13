package com.dilip.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dilip.security.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, String> {

	public Page<EmployeeEntity> findByfirstName(String id, Pageable pageable);

}