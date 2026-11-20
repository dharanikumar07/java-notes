package com.dbexample.springjdbcexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbexample.springjdbcexample.model.Student;
import com.dbexample.springjdbcexample.repository.StudentRepo;

@Service 
public class StudentService {

  @Autowired
  public StudentRepo sr;

  public void save(Student s)
  {
    sr.save(s);
  }
  public List<Student> getAllStudent()
  {
    return sr.findAll();
  }
}
