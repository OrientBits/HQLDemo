package com.cache;

import com.hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        //first level cache associated with session object - by default enabled
        Student student = s.get(Student.class, 1414);
        System.out.println(student);

        System.out.println("Working.............");

        Student student1 = s.get(Student.class, 1414);
        System.out.println(student1);

        boolean contains = s.contains(student);
        System.out.println(contains);

        s.close();
        sf.close();


    }

}
