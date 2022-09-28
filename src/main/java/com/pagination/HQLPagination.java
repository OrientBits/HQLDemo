package com.pagination;

import com.hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        Query sQuery = s.createQuery("from Student");

        sQuery.setFirstResult(5);
        sQuery.setMaxResults(5);

        List<Student> list = sQuery.list();
        for (Student st : list){
            System.out.println(st.getId() + " : "+st.getName());
        }

        s.close();
        sf.close();
    }
}
