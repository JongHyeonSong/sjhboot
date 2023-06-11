package com.example.sjhboot.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Hi {

  @GetMapping(value = "/h1")
  public String getMethodName() {
    return new String("GOGO");
  }

}
