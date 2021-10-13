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
            products = sess.createQuery("SELECT pp FROM product p JOIN p.ovkaarten c ON c.kaartNummer =" + ovChipkaart.getKaartNummer() +
                    " JOIN product pp ON pp.productNummer = p.productNummer").list();
        }  catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return products;
    }
}
