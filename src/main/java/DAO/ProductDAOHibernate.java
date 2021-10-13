package DAO;

import domain.OVChipkaart;
import domain.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOHibernate extends BaseDAOHibernate implements ProductDAO {
    public ProductDAOHibernate(Session sess) {
        super(sess);
    }

    @Override
    public boolean saveProduct(Product pr) throws HibernateException {
        try {

            sess.beginTransaction();
            sess.save(pr);
            sess.getTransaction().commit();

            return true;

        } catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product pr) throws HibernateException {
        sess.beginTransaction();
        sess.update(pr);
        sess.getTransaction().commit();
        return false;
    }

    @Override
    public boolean deleteProduct(Product pr) throws HibernateException {
        sess.beginTransaction();
        sess.update(pr);
        sess.getTransaction().commit();
        return false;    }

    @Override
    public List<Product> findAll() throws HibernateException {
        try {
            return sess.createQuery("FROM product", Product.class).getResultList();

        } catch (HibernateException exception){
            exception.getMessage();
        } catch (Exception exception){
            exception.getMessage();
        } return null;
    }

    @Override
    public List<Product> findByOvchipkaart(OVChipkaart ovChipkaart) throws HibernateException {
        List<Product> products = new ArrayList<>();
        try{
//            Wat ik heb gedaan is van van een product de chipkaarten ophalen waar het nummer gelijk is aan het nummer van de chipkaart
//            SELECT * FROM product WHERE
//            Vervolgens heb k de producten opgehaald van die chipkaart waar je net op heb gejoind met nog een join waar je p.productnummer
//            vergelijkt met het productnummer wat je hebt opgehaald
//            En dan select alles van het product waar je als tweede op joins
            products = sess.createQuery("FROM product p JOIN p.ovkaarten c " +
                    "ON c.kaartNummer = " + ovChipkaart.getKaartNummer() + " " +
                    "JOIN p.productNummer ON c.products WHERE ov_chipkaart = " + ovChipkaart.getKaartNummer()).list();
        }  catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return products;
    }
}
