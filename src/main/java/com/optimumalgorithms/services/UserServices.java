package com.optimumalgorithms.services;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimumalgorithms.entities.EmployeeDetails;
import com.optimumalgorithms.entities.UserDetails;
import com.optimumalgorithms.model.DataBaseUtility;
import com.optimumalgorithms.model.EmployeeRepository;
import com.optimumalgorithms.model.UsersRepository;
import com.optimumalgorithms.utilities.DevRankConstants;
import com.optimumalgorithms.utilities.EncryptionUtility;

/**
 * The class will be used to perform various userServices
 * 
 * @author OptimumAlgorithms
 * 
 */
@Service
public class UserServices {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DataBaseUtility dbUtility;

	@Autowired
	private EncryptionUtility encryptionUtility;

	private final DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

	private Logger logger = Logger
			.getLogger(this.getClass().getCanonicalName());

	private final Random RANDOM = new SecureRandom();
	public final int PASSWORD_LENGTH = 8;

	/**
	 * The method is used to create a user with root privilages, if its not
	 * already present in the dataBase
	 */
	public void createRootUserIfNotPresent() {

		logger.info("Going to fetch root user");
		UserDetails userDetails = dbUtility
				.findUserByRole(DevRankConstants.ROLE_ROOT_VALUE);

		if (null == userDetails) {
			logger.info("Root user not available. GOing to create new Root USer");

			UserDetails rootUser = new UserDetails();
			rootUser.setLoginId("root@optimumalgorithms.com");
			rootUser.setPassword(encryptionUtility.encrypt("password"));
			rootUser.setPasswordResetRequired(false);
			rootUser.setPasswordUpdated(true);
			rootUser.setStatus(DevRankConstants.STATUS_ACTIVE);
			userRepository.insert(rootUser);

			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setActive(DevRankConstants.STATUS_ACTIVE);
			employeeDetails.setDateOfBirth(Calendar.getInstance());
			employeeDetails.setEmailId("root@optimumalgorithms.com");
			employeeDetails.setFirstName("ROOT");
			employeeDetails.setLastName("ROOT");
			employeeDetails.setLoginId("root@optimumalgorithms.com");
			employeeRepository.insert(employeeDetails);

		} else {
			logger.info("Root user already present. No need to create again. Displaying the login page");
		}
	}

	/**
	 * Generate a random String suitable for use as a temporary password.
	 *
	 * @return String suitable for use as a temporary password
	 * @since 2.4
	 */
	public String generateRandomPassword() {
		// Pick from some letters that won't be easily mistaken for each
		// other. So, for example, omit o O and 0, 1 l and L.
		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

		String pw = "";
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = (int) (RANDOM.nextDouble() * letters.length());
			pw += letters.substring(index, index + 1);
		}
		return pw;
	}

	public com.optimumalgorithms.entities.UserDetails getUserDetailsbyUserName(
			String userName) {
		// TODO Auto-generated method stub
		return dbUtility.findUserByUserName(userName);
	}

	public EmployeeDetails getEmployeeDetailsByUserName(String userName) {
		// TODO Auto-generated method stub
		return dbUtility.findEmployeeDetailsByUserName(userName);
	}

}
