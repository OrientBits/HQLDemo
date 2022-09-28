package com.cascade;

import com.hql.Answer;
import com.hql.Question;
import com.hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class CascadeExample {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        // just add cascade in Question class, you don't have to commit answer to save in database

        Question st = new Question();

        st.setQuestionId(5732);
        st.setQuestion("What is Swing framework?");

        Answer a1 = new Answer(1231,"Use for development in java",st);
        Answer a2 = new Answer(1431,"Use for development desktop app",st);
        Answer a3 = new Answer(1531,"Use for development not mobile app",st);
        List<Answer> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        st.setAnswer(list);

        Transaction tx = s.beginTransaction();
        s.save(st);
        tx.commit();

        s.close();
        sf.close();

    }
}
