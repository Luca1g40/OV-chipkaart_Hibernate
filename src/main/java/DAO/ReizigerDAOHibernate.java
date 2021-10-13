package DAO;

import domain.Reiziger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReizigerDAOHibernate extends BaseDAOHibernate implements ReizigerDAO {


    public ReizigerDAOHibernate(Session sess) {
        super(sess);
    }

    @Override
    public boolean saveReiziger(Reiziger reiziger) throws HibernateException {
        try {
            sess.beginTransaction();
            sess.save(reiziger);
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
    public boolean updateReiziger(Reiziger reiziger) throws HibernateException {
        try {
            sess.beginTransaction();
            sess.update(reiziger);
            sess.getTransaction().commit();
        } catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return false;
    }

    @Override
    public boolean deleteReiziger(Reiziger reiziger) throws HibernateException {
        try {
            sess.beginTransaction();
            sess.delete(reiziger);
            sess.getTransaction().commit();
        } catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return false;
    }

    @Override
    public List<Reiziger> findAll() throws HibernateException {
        try {
            return sess.createQuery("FROM reiziger", Reiziger.class).getResultList();

        } catch (HibernateException exception){
            exception.getMessage();
        } catch (Exception exception){
            exception.getMessage();
        } return null;


    }

    @Override
    public Reiziger findById(int id) throws HibernateException {
        Reiziger reiziger = null;
        try {
            reiziger = sess.get(Reiziger.class, id);
        } catch (HibernateException exception){
            exception.getMessage();
        } catch (Exception exception){
            exception.getMessage();
        } return reiziger;
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) throws HibernateException {
        List<Reiziger> reiziger = new ArrayList<>();

        try {
            reiziger = sess.createQuery("FROM reiziger WHERE geboortedatum = '" + datum + "'").list();
        } catch (HibernateException exception){
            exception.getMessage();
        } catch (Exception exception){
            exception.getMessage();
        } return reiziger;
    }
}
