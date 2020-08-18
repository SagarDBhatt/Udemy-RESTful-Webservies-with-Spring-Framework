package com.onslearning.udemyrestfulwebservices.DependencyInjection;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class getUserID {
  public String createUserID(){
      return UUID.randomUUID().toString();
  }
}
