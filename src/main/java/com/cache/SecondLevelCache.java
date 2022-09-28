package com.cache;

import com.hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        Student s1 = s.get(Student.class, 1415);
        System.out.println(s1);
        s.close();


        Session s2 = sf.openSession();
        Student st2 = s2.get(Student.class, 1415);
        System.out.println(st2);
        s2.close();


        sf.close();

    }
}
