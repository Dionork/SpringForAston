package ru.aston.course;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Hero.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Fraction.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            System.out.println(session.find(Role.class, 1));
            session.getTransaction().commit();
        }
    }
}
