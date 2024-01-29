package com.example.sjhboot.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.sjhboot.util.UserData;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Hi {

  @GetMapping(value = "/h1")
  public String getMethodName() {
    log.info("김치김치\uAE40\uCE58 \uAE40\uCE58 김치 김치 김치김치김치 김치 김치 \uAE40\uCE58  \uAE40\uCE58 \uAE40\uCE58 \uAE40\uCE58");
    
    // UserData ud = new UserData("a", "B");;

    // UserData ud2 = ud.builder().name("hello").age("SOSO").build();
    UserData ud3 = UserData.builder().name("hello").age("SOSO").build();

    // System.out.println(ud.getAge());
    // System.out.println(ud2);
    System.out.println(ud3.name);
    // UserData ud1 = new UserData("f");

    // ERROR > WARN > INFO > DEBUG 순인듯?
    // log.debug("debugg");
    // log.warn("warng");
    // log.info("info");

    return new String("GOGO");
  }

}
