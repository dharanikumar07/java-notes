package com.example;


import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest hr, HttpServletResponse res)
  {
    res.setContentType("text/html");

    try {
        PrintWriter out= res.getWriter();

        out.println("<h2><b>Hello World</h2></b>");
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.print("Request coming .... ");
  }
  
}
