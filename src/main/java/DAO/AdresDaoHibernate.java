package DAO;

import domain.Adres;
import domain.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdresDaoHibernate extends BaseDAOHibernate implements AdresDAO {
    public AdresDaoHibernate(Session sess) {
        super(sess);
    }

    @Override
    public boolean saveAdres(Adres adres) throws HibernateException {
        try {

            sess.beginTransaction();
            sess.save(adres);
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
    public boolean updateAdres(Adres adres) throws HibernateException {
        sess.beginTransaction();
        sess.update(adres);
        sess.getTransaction().commit();
        return false;
    }

    @Override
    public boolean deleteAdres(Adres adres) throws HibernateException {
        try {
            sess.beginTransaction();
            sess.delete(adres);
            sess.getTransaction().commit();
        } catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return false;
    }

    @Override
    public List findByReiziger(Reiziger reiziger) throws HibernateException {
        List<Adres> adres = new ArrayList<>();
        try{
            adres = sess.createQuery("FROM adres WHERE reiziger = " + reiziger.getId()).list();
        }  catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return adres;
    }

    @Override
    public List<Adres> findAll() throws HibernateException {
        try {
            return sess.createQuery("FROM adres", Adres.class).getResultList();

        } catch (HibernateException exception){
            exception.getMessage();
        } catch (Exception exception){
            exception.getMessage();
        } return null;
    }
}
