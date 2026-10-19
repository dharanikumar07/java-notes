package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class L2Cache {
  public void doL2Cache()
  {
     SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.hql.FormerEmployees.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        FormerEmployees fe1 = session.find(FormerEmployees.class, 2);
        System.out.println(fe1);
        session.close();

        Session session1 = sf.openSession();
        FormerEmployees fe2 = session1.find(FormerEmployees.class, 2);
        System.out.println(fe2);

        session1.close();

        sf.close();
  }
}
