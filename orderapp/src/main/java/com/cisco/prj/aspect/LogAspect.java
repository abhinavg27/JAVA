package com.cisco.prj.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html

@Component
@Aspect
public class LogAspect {
	Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Before("execution(* com.cisco.prj.service.*.*(..))")
	public void doLogBefore(JoinPoint jp) {
		logger.info("Called : " + jp.getSignature());
		Object[] args = jp.getArgs();
		for(Object arg : args) {
			logger.info("Argument " + arg);
		}
	}
	
	@After("execution(* com.cisco.prj.service.*.*(..))")
	public void doLogAfter(JoinPoint jp) {
		logger.info("************");
	}
	
	@Around("execution(* com.cisco.prj.service.*.*(..))")
	public Object doProfile(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = new Date().getTime();
			Object ret = pjp.proceed();
		long endTime = new Date().getTime();
		logger.info("Time for " + pjp.getSignature() +" ==> " + (endTime - startTime) + "ms");
		return ret;
	}
	
	@AfterThrowing(value = "execution(* com.cisco.prj.api.*.*(..))", throwing ="ex")
	public void logExceptions(JoinPoint jp, Exception ex) {
		logger.info("Exception in ---> " + jp.getSignature() + " ==> " + ex.getMessage());
	}
	
}
