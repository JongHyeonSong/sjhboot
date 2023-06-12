package com.example.sjhboot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = { Exception.class })
	public String wre(Exception myEx) {
		System.out.println("익셉션 낫다@@@@");
		System.out.println(myEx.getMessage());
		return null;
	}
}
