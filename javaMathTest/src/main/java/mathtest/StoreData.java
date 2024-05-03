package mathtest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class StoreData {
    private static final StandardServiceRegistry REGISTRY;
    private static final Metadata METADATA;
    private static final SessionFactory FACTORY;

    static {
        REGISTRY = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        METADATA = new MetadataSources(REGISTRY).getMetadataBuilder().build();
        FACTORY = METADATA.getSessionFactoryBuilder().build();
    }

    public void saveQuestion(Question q) {
        save(q);
    }

    public void saveResult(Question q, String answer) {
        MathResult res = new MathResult(q, answer);
        save(res);
    }

    public Question getQuestion(int id) {

        return (Question) findIt(Question.class, id);
    }

    public Object findIt(Class cls, int id) {
        Session session = FACTORY.openSession();
        Transaction t = null;
        Object result = null;
        try {
            t = session.beginTransaction();
            result = session.get(cls, id);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public void save(Object o) {
        Session session = FACTORY.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.persist(o);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
