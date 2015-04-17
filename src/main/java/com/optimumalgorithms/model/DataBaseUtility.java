package com.optimumalgorithms.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.optimumalgorithms.entities.EmployeeDetails;
import com.optimumalgorithms.entities.UserDetails;

/**
 * The class provides various utility methods for the Persistence API. The class
 * uses MongoDBTemplate API for the database interactions.
 * 
 * 
 * @author OptimumAlgorithms
 * 
 */
@Component
public class DataBaseUtility {

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * The method is used to find a user based on the role specified
	 * 
	 * @param userRole
	 */
	public UserDetails findUserByRole(int userRole) {
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("role").is(userRole));

		// find the saved user again.
		UserDetails user = mongoTemplate.findOne(searchUserQuery,
				UserDetails.class);

		return user;
	}

	public UserDetails findUserByUserName(String userName) {
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("loginId")
				.is(userName));

		// find the saved user again.
		UserDetails user = mongoTemplate.findOne(searchUserQuery,
				UserDetails.class);

		return user;
	}

	public EmployeeDetails findEmployeeDetailsByUserName(String userName) {
		// TODO Auto-generated method stub
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("loginId")
				.is(userName));

		// find the saved user again.
		EmployeeDetails user = mongoTemplate.findOne(searchUserQuery,
				EmployeeDetails.class);
		
		return user;
	}

}
