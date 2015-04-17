package com.optimumalgorithms.entities;

import java.util.Collection;

import org.springframework.security.core.userdetails.User;

/**
 * It contains the login user details with the use of spring user. Keep the
 * attribute names in this class in sync with editProfile.jsp
 * 
 * @author OptimumAlgorithms
 */
public class CurrentUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5926534690748386796L;

	private final String firstName;
	private final String lastName;
	private final String loginId;
	private final String role;
	private final boolean isPasswordUpdated;
	private String email;
	private String password;

	public CurrentUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection authorities, String firstName,
			String lastName, String loginId, String role,
			boolean isPasswordUpdated, String dob, String email) {

		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);

		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.role = role;
		this.isPasswordUpdated = isPasswordUpdated;
		this.email = email;
	}

	/**
	 * @return the isPasswordUpdated
	 */
	public boolean isPasswordUpdated() {
		return isPasswordUpdated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public String getRole() {
		return this.role;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
