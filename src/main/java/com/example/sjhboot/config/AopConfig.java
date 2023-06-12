package com.example.sjhboot.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {

	@Around("execution(* com.example..controllers.*.*(..))")
	public Object aopgogo(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aop 스타트@@@@@@@");
		Object ob = pjp.proceed();
		System.out.println("aop 끗@@@@@@@");
		
		return ob;
	}
}
