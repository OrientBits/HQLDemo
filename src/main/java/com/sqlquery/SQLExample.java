package com.sqlquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import java.util.Arrays;
import java.util.List;

public class SQLExample {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        String q = "select * from student";

        NativeQuery sqlQuery = s.createSQLQuery(q);

        List<Object[]> list = sqlQuery.list();

        for (Object[] obj : list){
            System.out.println( obj[0] +" : "+obj[4]);
        }

        s.close();
        sf.close();
    }

}
