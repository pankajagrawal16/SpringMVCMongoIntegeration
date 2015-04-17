package com.optimumalgorithms.entities;

import java.util.Calendar;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.optimumalgorithms.utilities.DevRankConstants;

/**
 * This class maps to the EmployeeDetails table in the dataBase.
 * 
 * @author OptimumAlgorithms
 * 
 */
@Document(collection = DevRankConstants.EMPLOYEE_DETAILS_COLLECTION)
public class EmployeeDetails {

	@Id
	private long empDetailId;

	private String loginId;

	private String firstName;

	private String lastName;

	private Calendar dateOfBirth;

	private boolean isActive;

	private String emailId;

	public long getEmpDetailId() {
		return empDetailId;
	}

	public void setEmpDetailId(long empDetailId) {
		this.empDetailId = empDetailId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
