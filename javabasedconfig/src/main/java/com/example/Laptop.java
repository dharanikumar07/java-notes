package com.example;

import org.springframework.stereotype.Component;

@Component 
public class Laptop implements Computer {
  public Laptop()
  {
    System.out.println("Desktop object created");
  }
  
  public void code()
  {
    System.out.println("Coding in Laptop ...");
  }
}
