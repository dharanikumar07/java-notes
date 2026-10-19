package com.hibernate_learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.L2Cache;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setAge(20);
        s1.setName("Dharshini");
        s1.setRollNo(2);
        
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session ses = sf.openSession();
        
        // Transaction trans = ses.beginTransaction();

        // ses.persist(s1);

        // trans.commit();

        //find the record
        // Student result = ses.find(Student.class, 1);
        // System.out.println(result);
        
        //update or create the record
        // Transaction trans = ses.beginTransaction();
        // ses.merge(s1);
        // trans.commit();

        //remove the record
        // Transaction deltrans = ses.beginTransaction();
        // ses.remove(result);
        // deltrans.commit();


        ses.close();
        sf.close();

        // new UpdateLearning().doUpdateTask();
        //new OneToOne().relationshipMapping();
        //new OneToManyManyToOne().relationshipMapping();
        //new ManyToMany().relationshipMapping();

        //new Operations().doOperations();

        new L2Cache().doL2Cache();

    }
}