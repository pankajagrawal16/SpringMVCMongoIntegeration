package com.optimumalgorithms.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.optimumalgorithms.entities.CurrentUser;
import com.optimumalgorithms.entities.EmployeeDetails;
import com.optimumalgorithms.utilities.DevRankConstants;
import com.optimumalgorithms.utilities.EncryptionUtility;

/**
 * The service is used to authentiocate the login details as provided at the
 * login screen and decide the role accordingly
 * 
 * @author OptimumAlgorithms
 */

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private EncryptionUtility encryptionUtility;

	@Autowired
	private UserServices userService;

	private final DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * invoke at login to load the user details
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		String role = "";

		com.optimumalgorithms.entities.UserDetails userDetails = userService
				.getUserDetailsbyUserName(userName);
		EmployeeDetails empDetails = userService
				.getEmployeeDetailsByUserName(userName);

		// String employeeId = String.valueOf(userDetails.getEmployeeId());

		int auth = userDetails.getRole();
		if (auth == DevRankConstants.ROLE_ADMIN_VALUE) {
			role = DevRankConstants.ROLE_ADMIN;
		} else if (auth == DevRankConstants.ROLE_MEMBER_VALUE) {
			role = DevRankConstants.ROLE_MEMBER;
		} else if (auth == DevRankConstants.ROLE_ROOT_VALUE) {
			role = DevRankConstants.ROLE_ROOT;
		}

		// Decrypt the password
		String decryptedPassword = encryptionUtility.decrypt(userDetails
				.getPassword());

		String dob = dateformat.format(empDetails.getDateOfBirth().getTime());

		// Create a new user and return it to the framework
		return new CurrentUser(userName, decryptedPassword, true, true, true,
				true, getAuthorities(auth), empDetails.getFirstName(),
				empDetails.getLastName(), userName, role, true,
				dob,
				empDetails.getEmailId());
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>() {
			{
				add("ROLE_ROOT");
			}
		};

		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
