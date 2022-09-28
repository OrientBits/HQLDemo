package com.updatedata;

import com.google.gson.Gson;
import com.hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UpdateData {

    public static void main(String[] args) {


        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        Query query = s.createQuery("from Student");

        List<Student> list = query.list();

        Gson gson = new Gson();

        String jsonParse = gson.toJson(list);

        for(Student st : list){
            System.out.println(st.getName() +" : "+st.getCity());
        }

        System.out.println(jsonParse);


        s.close();
        sf.close();

    }

}
