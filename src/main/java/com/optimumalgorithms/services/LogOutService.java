package com.optimumalgorithms.services;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author OptimumAlgorithms
 */

@Service
public class LogOutService extends SimpleUrlLogoutSuccessHandler {

	public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response,
			Authentication authentication) throws java.io.IOException,
			javax.servlet.ServletException {

		SecurityContextHolder.clearContext();
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		response.sendRedirect("./logoff");

	}

}
