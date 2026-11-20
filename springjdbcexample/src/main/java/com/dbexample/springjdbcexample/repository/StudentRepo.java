package com.dbexample.springjdbcexample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dbexample.springjdbcexample.model.Student;

@Repository
public class StudentRepo {

  public JdbcTemplate jdbc;

  public JdbcTemplate getJdbc() {
    return jdbc;
  }

  @Autowired
  public void setJdbc(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public boolean save(Student s) {
    String sql = "insert into student(rollno,age,name) values(?,?,?)";
    int rows = jdbc.update(sql, s.getRollno(), s.getAge(), s.getName());
    System.out.println(rows + "affected");
    return rows > 0 ? true : false;
  }

  public List<Student> findAll() {
    String sql = "select * from student";
    RowMapper<Student> mapper = (rs, rowNum) -> {
      Student s = new Student();
      s.setRollno(rs.getInt("rollno"));
      s.setAge(rs.getInt("age"));
      s.setName(rs.getString("name"));
      return s;
    };

    return jdbc.query(sql, mapper);
  }

}
