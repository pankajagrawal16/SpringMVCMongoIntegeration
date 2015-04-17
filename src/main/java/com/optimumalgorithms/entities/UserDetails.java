package com.optimumalgorithms.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.optimumalgorithms.utilities.DevRankConstants;


/**
 * The class is used to represent the user information (the login details)
 * 
 * @author OptimumAlgorithms
 * 
 */
@Document(collection = DevRankConstants.USER_DETAILS_COLLECTION)
public class UserDetails {

	@Id
	private long userDetailId;
	
	private String loginId;


	private String password;

	private int role;

	private boolean status;
	
	private boolean passwordUpdated;

	private boolean passwordResetRequired;

	public long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(long userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isPasswordUpdated() {
		return passwordUpdated;
	}

	public void setPasswordUpdated(boolean passwordUpdated) {
		this.passwordUpdated = passwordUpdated;
	}

	public boolean isPasswordResetRequired() {
		return passwordResetRequired;
	}

	public void setPasswordResetRequired(boolean passwordResetRequired) {
		this.passwordResetRequired = passwordResetRequired;
	}

}
