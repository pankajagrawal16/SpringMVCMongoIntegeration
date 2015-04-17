package com.optimumalgorithms.utilities;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * use for logging the application log
 * 
 * @author OptimumAlgorithms
 */
@Aspect
public class LoggingAspect {

	/**
	 * Define the point cut for the com.devrank package
	 */
	@Pointcut("execution(* com.optimumalgorithms.*.*.*.*(..))")
	public void message() {

	}

	/**
	 * Execute before invoking any method of com.devrank package
	 */
	@Before("message()")
	public void traceEnter(final JoinPoint joinPoint) {

		Log logger = LogFactory.getLog(joinPoint.getClass());
		logger.info("Entering in Method::" + joinPoint.getSignature().getName());
		logger.info("Method Args::" + Arrays.asList(joinPoint.getArgs()));
	}

	/**
	 * Execute After invoking any method of com.devrank package
	 * 
	 */
	@AfterReturning(pointcut = "message()", returning = "result")
	public void traceExit(final JoinPoint joinPoint, final Object result) {
		Log logger = LogFactory.getLog(joinPoint.getClass());
		logger.info("Exiting in Method::" + joinPoint.getSignature().getName());
		logger.info("Method Args::" + Arrays.asList(joinPoint.getArgs()));

	}

	/**
	 * Execute if any method throw any exception of com.devrank package
	 * 
	 */
	@AfterThrowing(pointcut = "message()", throwing = "ex")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable ex) {

		Log logger = LogFactory.getLog(joinPoint.getClass());
		logger.error("Exception thrown in Method::"
				+ joinPoint.getSignature().getName());
		logger.error("Method Args::" + Arrays.asList(joinPoint.getArgs()));
		logger.error("Exception Message:::" + ex.getMessage());
		logger.error("Exception Cause::" + ex.getCause());
		logger.error("Exception StackTrace::" + ex.getStackTrace());

	}

}
