
import DAO.*;
import domain.Adres;
import domain.OVChipkaart;
import domain.Product;
import domain.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 *
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
//        testFetchAll();
        testReiziger();
    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    public static void testReiziger(){
        Session session = factory.openSession();
        AdresDaoHibernate adao = new AdresDaoHibernate(session);
        ReizigerDAOHibernate rdao = new ReizigerDAOHibernate(session);
        OVChipkaartDAO ovdao = new OVChipkaartDAOHibernate(session);
        ProductDAO pdao = new ProductDAOHibernate(session);

        Reiziger r1 = new Reiziger(71, "L", "", "Fransen", Date.valueOf("1993-3-27"));

        Adres a1 = new Adres(14, "3732BE", "153", "Henrica van erpweg", "De Bilt", r1);
        OVChipkaart ov1 = new OVChipkaart(35283, Date.valueOf("2018-05-31"), 2, 25, r1);
        ov1.addProduct(new Product(10, "Dagkaart 2e klas","Een hele dag onbeperkt reizen met de trein.", 24.00 ));
        Product pr = new Product(101, "test", "test beschrijving", 35);

//
//        System.out.println("------ovdao findall-------");
//        System.out.println(ovdao.findAll());
//        System.out.println("------adao findall-------");
//        System.out.println(adao.findAll());
//        System.out.println("------pdao findall-------");
//        System.out.println(pdao.findAll());
//        System.out.println("------rdao findall-------");
//        System.out.println(rdao.findAll());
//
//        System.out.println("------ovdao findbyreiziger-------");
//        System.out.println(ovdao.findByReiziger(r1));
//        System.out.println("------adao findbyreiziger-------");
//        System.out.println(adao.findByReiziger(r1));
        System.out.println("------pdao findbyovchip-------");
        System.out.println(pdao.findByOvchipkaart(ov1));
//        System.out.println("------rdao findbygbdatum-------");
//        System.out.println(rdao.findByGbDatum("1993-3-27"));
//        System.out.println("------rdao findbyid-------");
//        System.out.println(rdao.findById(1));
//
//
//        System.out.println("------rdao save-------");
//        System.out.println(rdao.findAll().size());
////        rdao.saveReiziger(r11);
//        System.out.println(rdao.findAll().size());
//        System.out.println("------rdao delete-------");
//        rdao.deleteReiziger(r1);
//        System.out.println(rdao.findAll().size());
//
//        System.out.println("------ovdao save-------");
//        System.out.println(ovdao.findAll().size());
////        ovdao.saveOVChipkaart(ov1);
//        System.out.println(ovdao.findAll().size());
//        System.out.println("------rdao delete-------");
//        ovdao.deleteOVChipkaart(ov1);
//        System.out.println(ovdao.findAll().size());
//
//        System.out.println("------adao save-------");
//        System.out.println(adao.findAll().size());
////        adao.saveAdres(a1);
//        System.out.println(adao.findAll().size());
//        System.out.println("------rdao delete-------");
//        adao.deleteAdres(a1);
//        System.out.println(adao.findAll().size());
//
//        System.out.println("------pdao save-------");
//        System.out.println(pdao.findAll().size());
////        pdao.saveProduct(pr);
//        System.out.println(pdao.findAll().size());
//        pdao.deleteProduct(pr);
//        System.out.println(pdao.findAll().size());
    }
}