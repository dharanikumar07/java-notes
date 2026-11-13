package com.learning_basic.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component ("Demo")
public class Demo {
  @Autowired 
  public Demo1 demo1;

  public void PrintCompile()
  {
    System.out.println("Compiling ....");
  }

  public void printAutowiredFunction()
  {
    demo1.PrintTesting();
  }
}
