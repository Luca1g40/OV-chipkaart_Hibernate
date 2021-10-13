package DAO;

import domain.Adres;
import domain.OVChipkaart;
import domain.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDAOHibernate extends BaseDAOHibernate implements OVChipkaartDAO {
    public OVChipkaartDAOHibernate(Session sess) {
        super(sess);
    }

    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) throws HibernateException {
        List<OVChipkaart> ovKaart = new ArrayList<>();
        try{
            ovKaart = sess.createQuery("FROM ov_chipkaart WHERE reiziger = " + reiziger.getId()).list();
        }  catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return ovKaart;
    }

    @Override
    public boolean deleteOVChipkaart(OVChipkaart ov) throws HibernateException {
        try {
            sess.beginTransaction();
            sess.delete(ov);
            sess.getTransaction().commit();
        } catch (HibernateException exception) {
            exception.getMessage();

        } catch (Exception exception) {
            exception.getMessage();
        }
        return false;    }

    @Override
    public boolean saveOVChipkaart(OVChipkaart ov) throws HibernateException {
        try {

            sess.beginTransaction();
            sess.save(ov);
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
    public boolean updateOVChipkaart(OVChipkaart ov) throws HibernateException {
        sess.beginTransaction();
        sess.update(ov);
        sess.getTransaction().commit();
        return false;
    }

    @Override
    public List<OVChipkaart> findAll() throws HibernateException {
        try {
            return sess.createQuery("FROM ov_chipkaart ", OVChipkaart.class).getResultList();

        } catch (HibernateException exception){
            exception.getMessage();
        } catch (Exception exception){
            exception.getMessage();
        } return null;
    }
}
