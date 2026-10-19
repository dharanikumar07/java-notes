package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Operations {
  public void doOperations() {
    SessionFactory sf = new Configuration()
        .configure()
        .addAnnotatedClass(com.hql.FormerEmployees.class)
        .buildSessionFactory();

    Session ses = sf.openSession();

    Query query1 = ses.createQuery("from FormerEmployees", FormerEmployees.class);
    List<FormerEmployees> result1 = query1.getResultList();
    System.out.println("All Employees:");
    result1.forEach(System.out::println);


    String department = "Engineering";

    Query query2 = ses.createQuery("FROM FormerEmployees WHERE department = :department",
        FormerEmployees.class);
    query2.setParameter("department", department);

    List<FormerEmployees> departmentEmployees = query2.getResultList();

    System.out.println("Department Employees:");
    departmentEmployees.forEach(System.out::println);

    Query query3 = ses.createQuery("FROM FormerEmployees WHERE department = 'Finance'",
        FormerEmployees.class);
    List<FormerEmployees> financeEmployees = query3.getResultList();
    
    System.out.println("Finance Employees:");
    financeEmployees.forEach(System.out::println);

    ses.close();
    sf.close();
  }
}
