package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.Alien;
import com.example.Desktop;
import com.example.Laptop;
import com.example.Computer;

@Configuration
@ComponentScan ("com.example")
public class AppConfig {

  // @Bean 
  // //@Bean(name = "alien1"}
  // //@Scope ("prototype")
  // public Alien alien(Computer com) //@Autowired @Qualifier ("laptop")
  // {
  //   Alien al = new Alien();
  //   al.setAge(20);
  //   al.setCom(com);
  //   return al;
  // }
  
  // @Bean
  // @Primary 
  // public Desktop desktop()
  // {
  //   return new Desktop();
  // }

  // @Bean
  // public Laptop laptop()
  // {
  //   return new Laptop();
  // }
  
}
