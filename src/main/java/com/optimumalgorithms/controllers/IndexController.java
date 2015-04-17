package com.optimumalgorithms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.optimumalgorithms.services.UserServices;

/**
 * The class acts as a basic controller for the index page or the home page of
 * the application. The class is annotated with @Controller tag and is thus
 * loaded by the application context which is mapped by the
 * context:component-scan tag in the context-servlet.xml
 * 
 * @author OptimumAlgorithms
 *
 */
@Controller
public class IndexController {

	@Autowired
	private UserServices userServices;

	/**
	 * Do not name your index file as index.jsp; this simply is a bug in tomcat
	 * as mentioned at {@link http
	 * ://stackoverflow.com/questions/5252065/spring-mvc
	 * -how-to-create-a-default-controller-for-index-page}
	 * 
	 * What the solution I've used here is to change the name of my index page
	 * to be home; in that case when the home page will be loaded by
	 * spring-security as mentioned in the login page, it will be redirected to
	 * this method and this method after creating the root-user will redirect it
	 * to home page
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/", "/index", "index.html", "index.jsp", "home",
			"home.html", "home.jsp", "/**/index" }, method = RequestMethod.GET)
	public ModelAndView showIndexPage() {
		// Check if the root user is present or not
		userServices.createRootUserIfNotPresent();

		ModelAndView indexView = new ModelAndView("home");

		return indexView;
	}
}
