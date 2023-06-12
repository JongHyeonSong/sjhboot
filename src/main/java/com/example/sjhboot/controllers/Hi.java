package com.example.sjhboot.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Hi {

  @GetMapping(value = "/h1")

  public String getMethodName() {

    // ERROR > WARN > INFO > DEBUG 순인듯?
    log.debug("debugg");
    log.warn("warng");
    log.info("info");

    return new String("GOGO");
  }

}
