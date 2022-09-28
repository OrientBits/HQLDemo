package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HQLExample
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();

        Session s = sf.openSession();

        //HQL
        System.out.println("------------adding data into table------------");
        Transaction tx1 = s.beginTransaction();
        for (int i = 0; i < 10; i++) {
            Student student = new Student(i+10,"Orient "+i, "Delhi"+i);
            s.save(student);
        }
        tx1.commit();

        System.out.println("------------fetching data from table------------");
        //fetching data from table
        String queryString = "from Student where city='chatra' ";
        //String query = "from Student where city=:x ";
        //q1.setParameter("x","Chatra"); // dynamic value passing
        Query query = s.createQuery(queryString);

        //single (q.uniqueResult)
        //multiple - list

        List<Student> list = query.list();
        for (Student student : list) {
            System.out.println(student.getName()+" : "+student.getCertificate().getCourse());
        }


        System.out.println("------------deleting data from table------------");
//        //deleting data from table
//        Transaction tx = s.beginTransaction();
//        Query q1 = s.createQuery("delete Student where city=:c");
//        q1.setParameter("c","Kolkata");
//        int reminder = q1.executeUpdate();
//        tx.commit();
//
//        System.out.println("Deleted: r = "+reminder);


        System.out.println("------------update data into table------------");
        //deleting data from table
        Transaction tx = s.beginTransaction();
        Query q1 = s.createQuery("update Student set city=:c where name=:n");
        q1.setParameter("c","Kolkata");
        q1.setParameter("n","Ramshek");
        int reminder = q1.executeUpdate();
        tx.commit();

        System.out.println("Updated: r = "+reminder);


        System.out.println("------------Inner Join tables------------");
        Query q3 = s.createQuery(
                "select q.question, q.questionId, a.answer from Question as q JOIN q.answer a");

        List<Object[]> list1 = q3.getResultList();

        for (Object[] obj: list1){
            System.out.println(Arrays.toString(obj));
        }

    }
}
