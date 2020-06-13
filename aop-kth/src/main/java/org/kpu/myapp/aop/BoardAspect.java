package org.kpu.myapp.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardAspect {
	private static final Logger logger = LoggerFactory.getLogger(BoardAspect.class);
	static String name = "";
	static String type = "";

	@Around("execution(* org.kpu.myapp.controller..*Controller.*(..))"
			+ " or execution(* org.kpu.myapp.service..*Impl.*(..))"
			+ " or execution(* org.kpu.myapp.persistence..*Impl.*(..))")
	public Object logPrint(ProceedingJoinPoint pjp) throws Throwable {

		Object result = pjp.proceed();
		type = pjp.getSignature().getDeclaringTypeName();

		if (type.indexOf("Controller") > -1) {
			name = "Controller : ";
		} else if (type.contains("Service")) {
			name = "Service : ";
		} else if (type.contains("DAO")) {
			name = "Persistence : ";
		}
		logger.info("=======================================================");
		logger.info(name + type + "." + pjp.getSignature().getName() + "()");
		logger.info("Argument/Parameter : " + Arrays.toString(pjp.getArgs()));
		logger.info("=======================================================");

		return result;
	}
}
