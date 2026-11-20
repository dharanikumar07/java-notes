package com.dbexample.springjdbcexample;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dbexample.springjdbcexample.model.Student;
import com.dbexample.springjdbcexample.service.StudentService;

@SpringBootApplication
public class SpringjdbcexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcexampleApplication.class, args);

		StudentService ss = context.getBean(StudentService.class);

		Student stud = context.getBean(Student.class);
		stud.setAge(22);
		stud.setName("dharanikumar");
		stud.setRollno(07);
		ss.save(stud);
		List<Student> students = ss.getAllStudent();
		System.out.println(students);

	}

}
