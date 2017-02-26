package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        ServiceRegistry registry = new ServiceRegistryBuilder().buildServiceRegistry();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

}
