package com.optimumalgorithms.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.optimumalgorithms.entities.EmployeeDetails;

/**
 * An extension of MongoRepository
 * 
 * @author OptimumAlgorithms
 *
 */
@Repository
public interface EmployeeRepository extends
		MongoRepository<EmployeeDetails, Integer> {
}
