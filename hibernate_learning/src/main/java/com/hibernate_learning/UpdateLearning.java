package com.hibernate_learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

public class UpdateLearning {
  public void doUpdateTask() {
    Configuration cfg = new Configuration()
        .addAnnotatedClass(Items.class)
        .configure("hibernate.cfg.xml");

    SessionFactory sf = cfg.buildSessionFactory();

    Session session = sf.openSession();

    Laptop l1 = new Laptop();
    l1.setBrand("Dell");
    l1.setProcessor("Intel Core 5");
    l1.setRam(8);

    Items i1 = new Items();
    i1.setLaptop(l1);
    i1.setOwner_name("Dharanikumar");
    i1.setOwner_age(22);

    Transaction trans = session.beginTransaction();
    session.persist(i1);
    trans.commit();

    session.close();
    sf.close();

  }
}
