package com.hibernate_learning;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
  @Id
  int rollNo;
  String name;
  int age;
  public int getRollNo() {
    return rollNo;
  }
  public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("rollNo=").append(rollNo);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
