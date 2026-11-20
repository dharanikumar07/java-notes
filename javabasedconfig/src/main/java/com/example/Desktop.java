package com.example;

import org.springframework.stereotype.Component;

@Component 
public class Desktop implements Computer {

  public Desktop()
  {
    System.out.println("Desktop object created");
  }
  
  public void code()
  {
    System.out.println("Coding in desktop ...");
  }
}
