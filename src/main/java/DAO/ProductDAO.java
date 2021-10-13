package DAO;

import domain.OVChipkaart;
import domain.Product;
import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProductDAO {

    boolean saveProduct(Product pr) throws HibernateException;

    boolean updateProduct(Product pr) throws HibernateException;

    boolean deleteProduct(Product pr) throws HibernateException;

    List<Product> findAll() throws HibernateException;

    List<Product> findByOvchipkaart(OVChipkaart ovChipkaart) throws HibernateException;
}
