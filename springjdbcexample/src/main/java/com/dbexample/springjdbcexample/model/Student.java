package com.dbexample.springjdbcexample.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope ("prototype")
public class Student {

  public int rollno;
  public int age;
  public String name;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", age=" + age + ", name=" + name + ", getRollno()=" + getRollno()
                + ", getAge()=" + getAge() + ", getName()=" + getName() + "]";
    }

  
  
}
